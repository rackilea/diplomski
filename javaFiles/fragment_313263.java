public void getjs(){
  FacesContext context = FacesContext.getCurrentInstance();
  Map<String, String> map = context.getExternalContext().getRequestParameterMap();
  String value = (String) map.get("param");
  System.out.println("**************** The Javascript is " + value);
}