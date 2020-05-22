private void updateSessionHashSet(HttpServletRequest req){
    String csv = req.getParameter("theCsv");
    Set<String> hs = new HashSet<String>();
    String[] arr = csv.split(",");
    for(int i = 0; i < arr.length; i++){
        hs.add(arr[i].trim());
    }
    req.getSession().setAttribute("theHashSet", hs);
}