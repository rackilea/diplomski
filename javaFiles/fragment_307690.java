UserInfo userInfo=new UserInfo();
    userInfo.setName("zyr");
    userInfo.setPassword("123");
    userInfo.setTestString(new ArrayList<>());
    System.out.println(userInfo);
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    ObjectOutputStream oos=new ObjectOutputStream(bos);
    oos.writeObject(userInfo);
    byte[] objectBytes = bos.toByteArray();
    oos.close();
    bos.close();


    ProcessInputStream processInputStream = new ProcessInputStream(new ByteArrayInputStream(objectBytes),objectBytes.length);


    processInputStream.addListener(percent -> System.out.println(percent));
    ObjectInputStream ois=new ObjectInputStream(processInputStream);


    UserInfo target = (UserInfo) ois.readObject();
    System.out.println(target);