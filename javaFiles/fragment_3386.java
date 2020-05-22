class NoWarn {
  public static Map<String, String[]> getParameterMap(ServletRequest r) 
  {
    @SuppressWarnings("unchecked")
    Map<String, String[]> result = r.getParameterMap();
    return result;
  }
}