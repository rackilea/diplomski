public class JavaVariableAssigner {

                                                                 //javascript-stored objects do not appear to the
    private static ArrayList<Object> gcLock = new ArrayList();   //garbadge collector so we need to make sure
                                                                 //they don't get deleted by always keeping
                                                                 //a reference to them from this list


    public static void addAllMembers(WebEngine browser, Object obj) {
        gcLock.add(obj);

        ((JSObject) browser.executeScript("window")).setMember("java", obj);

        for(Method m : obj.getClass().getDeclaredMethods()) {
            ArrayList<String> parameterNames = new ArrayList();
            for(Parameter p : m.getParameters()) parameterNames.add(p.getName());
            String params = String.join(",", parameterNames.toArray(new String[0]));
            browser.executeScript("function "+m.getName()+"("+params+"){ return java."+m.getName()+"("+params+"); };");
        }

        for(Field  f : obj.getClass().getDeclaredFields()) {
            browser.executeScript("var "+f.getName()+" = java."+f.getName()+";");
        }
    }

}