protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        Hashtable<String, String> days = new Hashtable<>();
        Enumeration<String> names = request.getParameterNames();
        while(names.hasMoreElements()){
            String param = names.nextElement();
            String value = request.getParameter(param);
            days.put(param, value);
        }
        System.out.println(days);
}