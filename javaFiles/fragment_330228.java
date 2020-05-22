JCodeModel codeModel = new JCodeModel();
    JDefinedClass bull = codeModel._class(JMod.PUBLIC, "com.Bull", ClassType.INTERFACE);
    System.out.println("is interface " + bull.isInterface());
    codeModel.build(new File("/home/user"));
    System.out.println("done!");

    BufferedReader br = new BufferedReader(new FileReader("/home/user/com/Bull.java"));
    String line = null;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }