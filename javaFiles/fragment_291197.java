private void populateMap(String objectType, String objectName, UMRDocumentationDTO documentationDTO){
      if("Domain".equals(objectType) || "DomainCombo".equals(objectType))
      {
          MMTUtil.getDomainDocumentationMap().put(objectName, documentationDTO.getDocumentationLink());
      }
}