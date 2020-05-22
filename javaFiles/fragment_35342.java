public boolean checkPassword(String enteredUserName, String enteredPassord)
{
        Iterator<Entry<Integer, User>> it = uc.entrySet().iterator();
        while (it.hasNext()){
            //some code to validate user input against HashMap entries
            User u = it.next().getValue();
            if (u.getUserName().equals(enteredUserName())
                return u.getPassword().equals(enteredPassword);
        }

}