public static void main(String[] args) {
        HashMap<String, Element> map = new HashMap<String, Element>();
        map.put("com.a.service", new Element(0.05, 0.07, 0.02, "IMPROVED"));
        //...
        Element a = map.get("com.a.service"); //x=0.05, x2=0.07, result=0.02, performance = IMPROVED
}