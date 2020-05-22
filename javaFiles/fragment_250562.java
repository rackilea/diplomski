public void deleteUser() {

        FacebookUser user1= new FacebookUser();
        System.out.println("Enter username you want to remove: ");
        String removeUser = input.nextLine();  
        boolean isPresent = false; 
        for(FacebookUser user:users){
        if(user.getUsername.equals(removeUser)){
                isPresent = true;
            System.out.println("Enter Password");
            password = sc.nextLine();
            if(user.getPassword.equals(password)){
                users.remove(user);
                break;
            }else{
            System.out.println("Incorrect Password");
            }
        }
        }
        if(!isPresent){
        System.out.pritln("User does not exist");
        }
        }