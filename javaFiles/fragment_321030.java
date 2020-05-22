if (in.readUTF().equalsIgnoreCase("http://localhost:8181")) {    // !!!!!!
     System.out.println("its http://localhost:8181");
       serverS.close();
     } else if (in.readUTF().equals("http://localhost:8181/pic")) {  // !!!!!
       System.out.println("its pic");
        serverS.close();
     }