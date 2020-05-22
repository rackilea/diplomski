File file = new File("Users.dat"); 
     if (!file.exists()) { 
        User user = new User(1, "Mahesh", "Teacher"); 
        userList = new ArrayList<User>(); 
        userList.add(user); 
        saveUserList(userList); 
     }else{ 
        FileInputStream fis = new FileInputStream(file); 
        ObjectInputStream ois = new ObjectInputStream(fis); 
        userList = (List<User>) ois.readObject(); 
        ois.close(); 
     }