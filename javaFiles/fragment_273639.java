private void createCaseParticipant(long caseId, CaseParticipantDTO caseParticipantDTO)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION_HEADER_NAME, BASIC_AUTHORIZATION_HEADER_PREFIX + cmsRestApiCreds);
        headers.add("caseId",caseId.toString());
        headers.add("caseParticipantDTO", caseParticipantDTO.toString());
        HttpEntity<CaseParticipantDTO> postRequest = new HttpEntity<CaseParticipantDTO>(caseParticipantDTO, headers);
    }