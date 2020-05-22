Document doc = new SAXBuilder().build(new File("ACL.xml"));
    Element root = doc.getRootElement();
    for (Element testcase : root.getChildren()) {
        int id = Integer.parseInt(testcase.getChildText("id"));
        String name = testcase.getChildText("testCaseName");
        String expect = testcase.getChildText("expectedResult");
        Map<String,String> params = new LinkedHashMap<String,String>();
        Element parmemt = testcase.getChild("parameter");
        if (parmemt != null) {
            Iterator<Element> it = parmemt.getChildren().iterator();
            while (it.hasNext()) {
                Element key = it.next();
                if (!"key".equals(key.getName())) {
                    throw new IllegalStateException("Expected key but got " + key);
                }
                if (!it.hasNext()) {
                    throw new IllegalStateException("Expected value for key " + key);
                }
                Element val = it.next();
                if (!"value".equals(val.getName())) {
                    throw new IllegalStateException("Expected value but got " + val);
                }
                params.put(key.getValue(), val.getValue());
            }
        }
        System.out.printf("Processing test case %d -> %s\n    Expect %s\n    Parameters: %s\n",
             id, name, expect, params.toString());
    }