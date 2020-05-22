@POST
public void printDetails() {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    Map<String, String[]> mapp =  request.getParameterMap();
    for(String key : mapp.keySet()) {
        System.out.println(key + "     " + mapp.get(key)[0]);
    }
}