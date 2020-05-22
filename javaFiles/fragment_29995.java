public String getContactForm(@RequestParam(required = true) Long moduleId, @RequestParam(required = true) String url, @RequestParam(required=false) List<String> prefills, Long mySiteId, Integer pageShortId,
      DefaultPageParameters defaultPageParameters, ModelMap model, HttpServletRequest request, HttpServletResponse response, Locale locale) throws Exception {


  private void prefillFieldsWithData(List<String> prefills, ModelMap model, BasicContactFormVo contactFormVo) {
    if(prefills != null && !prefills.isEmpty()){
      Map<String, String> valuesOfCustomFields = new HashMap<String, String>();
      List<ContactFormElementVo> customFormElements = contactFormVo.getCustomFormElements();
      for (String prefillData : prefills) {
        if(prefillData.contains("|")){
          String[] prefillFieldData = prefillData.split("|");
          for (ContactFormElementVo contactFormElementVo : customFormElements) {
            if(contactFormElementVo.getLabel().equals(prefillFieldData[0])){
              valuesOfCustomFields.put("cfe"+contactFormElementVo.getId().toString(), prefillFieldData[1]);
              break;
            }
          }                    
        }
      }
      model.addAttribute("customFieldValues",valuesOfCustomFields);
    }
  }