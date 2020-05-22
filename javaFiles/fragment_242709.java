private Single<Map<String, CreationResponse>> createSegment(List<Integer> audienceIds) {
    try {
      createToken();
    }
    catch (ValidationServiceException e) {
      SegmentInformation segmentInformation = new SegmentInformation();
      segmentInformation.setError(SEGMENT_CREATION_EXCEPTION.getMessage());
      Map<String, CreationResponse> returnMap = new HashMap<>();
      returnMap.put(segmentInformation.getAudienceId().toString(), segmentInformation);
      logger.error(TOKEN_CREATION_EXCEPTION.getMessage());
    }
    catch (IOException e) {
      SegmentInformation segmentInformation = new SegmentInformation();
      segmentInformation.setError(SEGMENT_CREATION_EXCEPTION.getMessage() + SEGMENT_CODE_EXIST.getMessage());
      Map<String, CreationResponse> returnMap = new HashMap<>();
      returnMap.put(segmentInformation.getAudienceId().toString(), segmentInformation);
      logger.error(SEGMENT_CREATION_EXCEPTION.getMessage());
    }

    List<ListBasedAudienceFetcher.AcAudience> audienceDataMap = audienceIds != null ?
      impl.processAudienceByIds(audienceIds) :
      impl.processAudience();

    if (audienceDataMap.isEmpty()) {
      SegmentInformation segmentInformation = new SegmentInformation();
      segmentInformation.setError(PROGRAMS_NOT_CREATED.getMessage());
      Map<String, CreationResponse> returnMap = new HashMap<>();
      returnMap.put(CREATE_PROGRAM.getMessage(), segmentInformation);
      return Single.just(returnMap);
    }

    Map<String, CreationResponse> returnMap = new HashMap<>();
    for (ListBasedAudienceFetcher.AcAudience audienceData : audienceDataMap) {
      SegmentInformation segmentInformation = new SegmentInformation();
      segmentInformation.setMemberId(memberId);
      segmentInformation.setAudienceId(audienceData.getId());
      String audienceName = getSegmentName(audienceData);
      segmentInformation.setAudienceName(audienceName);
      try {
        String createSegmentResponse = Util.post(new PayLoad()
          .setUrl(AppNexusConstants.APPNEXUS_SEGMENT_URL + "/" + memberId)
          .setRequestType(Request.POST)
          .setHeader(getAppnexusAuthHeader())
          .setPayload(createSegmentPayload(audienceData, memberId)));
        SegmentResponse segmentResponse = Util.mapper.readValue(createSegmentResponse, SegmentResponse.class);
        if (segmentResponse != null
          && segmentResponse.getResponse().getStatus() != null
          && segmentResponse.getResponse().getStatus().equals("OK")) {
          BillingData billingData = billingSegment(audienceData, segmentResponse.getResponse().getSegmentData());
          segmentResponse.getResponse().getSegmentData().setBillingData(billingData);
        } else {
          segmentInformation.setError(SEGMENT_CREATION_EXCEPTION.getMessage() + audienceData.getId());
        }
        segmentInformation.setSegmentCreationResponses(segmentResponse);
        returnMap.put(audienceData.getId().toString(), segmentInformation);
      }
      catch (IOException e) {
        segmentInformation.setError(SEGMENT_CREATION_EXCEPTION.getMessage() + SEGMENT_CODE_EXIST.getMessage());
        returnMap.put(segmentInformation.getAudienceId().toString(), segmentInformation);
        logger.error(SEGMENT_CREATION_EXCEPTION.getMessage());
      }
    }

    return Single.just(returnMap);
  }