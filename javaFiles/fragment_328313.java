String first = "first";
    String second = "second";
    HashMap<String, Object> saved = new HashMap<String, Object>();
    saved.put("A", first);
    saved.put("B", second);

    try {
        FileOutputStream fos = new FileOutputStream("test.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(saved);
        oos.flush();
        oos.close();
        fos.close();


        FileInputStream fis = new FileInputStream("test.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);

        HashMap<String,Object> retreived = (HashMap<String,Object>)ois.readObject();
        fis.close();

        System.out.println(retreived.get("A"));
        System.out.println(retreived.get("B"));
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
}