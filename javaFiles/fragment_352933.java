HashMap<String, Object> hashMap = new HashMap<String, Object>();
 JTextArea value = new JTextArea();
 value.setText("jArea text");
 hashMap.put("jarea", value);

 String property = BeanUtils.getProperty(hashMap, "jarea.text");
 System.out.println(property);