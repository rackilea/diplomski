List<APIBean> apiBeans = new ArrayList<>();
Iterator<APIQueue> i = apiQueueData.iterator();
while (i.hasNext()) {
    String applId = i.next().getParameterValue();
    String transactionType = i.next().getParameterValue();
    String phsOrgCode = i.next().getParameterValue();
    String roleTypeCode = i.next().getParameterValue();
    String personId = i.next().getParameterValue();
    String versionId = i.next().getParameterValue();
    apiBeans.add(new APIBean(applId, transactionType, phsOrgCode, roleTypeCode, personId, versionId));
}