class SimpleClient {
    public static void main(String args[]) throws Exception {

        // Connection setup
        Socket s = new Socket("localhost",2002);
        OutputStream os = s.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        InputStream is = s.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        testobject to;

        // Conversation

        System.out.println("sending object 1");
        to = new testobject(1,"object 1","field1","field2","field3","field4");
        oos.writeObject(to);

        System.out.println("receiving object 2");
        to = (testobject)ois.readObject();
        System.out.println(to.id);

        System.out.println("sending object 3");
        to = new testobject(2,"object 3","field1","field2","field3","field4");
        oos.writeObject(to);

        System.out.println("receiving object 4");
        to = (testobject)ois.readObject();
        System.out.println(to.id);

        // Connection shutdown
        ois.close();
        oos.close();
        s.close();
    }
}

class SimpleServer {
    public static void main(String args[]) throws Exception {

        // Connection setup
        ServerSocket ss = new ServerSocket(2002);
        Socket s = ss.accept(); // only handle a single connection
        ss.close(); // so we can immediately stop listening for more
        OutputStream os = s.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        InputStream is = s.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        testobject to;

        // Conversation

        System.out.println("receiving object 1");
        to = (testobject)ois.readObject();
        System.out.println(to.id);

        System.out.println("sending object 2");
        to = new testobject(2,"object 2","field1","field2","field3","field4");
        oos.writeObject(to);

        System.out.println("receiving object 3");
        to = (testobject)ois.readObject();
        System.out.println(to.id);

        System.out.println("sending object 4");
        to = new testobject(4,"object 4","field1","field2","field3","field4");
        oos.writeObject(to);

        // Connection shutdown
        ois.close();
        oos.close();
        s.close();
    }
}