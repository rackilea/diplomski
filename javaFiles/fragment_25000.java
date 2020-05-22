public boolean logLogged(HttpSession session){

    Enumeration<String> names = session.getAttributeNames();

    boolean loggedTmp=false;

    while(names.hasMoreElements()){

        String name = (String) names.nextElement();

        if(name.equals("logged")){
            loggedTmp = (Boolean) session.getAttribute("logged");
        }
    }

    return loggedTmp;

}