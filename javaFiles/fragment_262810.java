private static final String QA_HOSTED_ZONE_ID = "UUIDFromConsole";                
private static final String REDIRECT_DNS = "DNS to want the cname to route to";
GetHostedZoneRequest getHostedZoneRequest = new GetHostedZoneRequest(HOSTED_ZONE_ID);
    GetHostedZoneResult result = route53Client.getHostedZone(getHostedZoneRequest); ResourceRecordSet resourceRecordSet = new ResourceRecordSet("DN4TheRecordSet", RRType.CNAME);
    GeoLocation geoLocation = new GeoLocation();
    geoLocation.setContinentCode("NA");
    geoLocation.setSubdivisionCode("NY");
    resourceRecordSet.setGeoLocation(geoLocation);
    resourceRecordSet.setTTL(50L);
    resourceRecordSet.setGeoLocation(geoLocation);
    resourceRecordSet.setSetIdentifier("uniqueid-statecode");
    resourceRecordSet.setResourceRecords(Arrays.asList(new ResourceRecord(REDIRECT_DNS))); // This line being missing cause the exception
    Change addStateChange = new Change(ChangeAction.CREATE, resourceRecordSet);
    ChangeBatch changeBatch = new ChangeBatch(Arrays.asList(addStateChange));
    ChangeResourceRecordSetsRequest changeResourceRecordSetsRequest = new ChangeResourceRecordSetsRequest().withHostedZoneId(HOSTED_ZONE_ID).withChangeBatch(changeBatch);
    route53Client.changeResourceRecordSets(changeResourceRecordSetsRequest);