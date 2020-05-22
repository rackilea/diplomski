MyBean bean=new MyBean();
    bean.setId(new Long(1));
    bean.setStatus("pending");
    bean.setStatus1("pending");
    bean.setStatus2("pending");
    bean.setStatus3("pending");

    Map<String, Integer> temp=new HashMap<String, Integer>();
    temp.put("width",1000);
    temp.put("height",1507);
    bean.setSpecs(temp);

    //Object to json
    StringWriter sw=new StringWriter();
    ObjectMapper mapper=new ObjectMapper();
    mapper.writeValue(sw,bean);
    System.out.println(sw.toString());


     //json to object
    MyBean newBean=mapper.readValue(sw.toString(), MyBean.class);
    System.out.println(newBean.toString());