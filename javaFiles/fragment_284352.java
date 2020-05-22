for (int k = 0; k < login.length; k++) {
    String[] split = login[k].split(";");
    String user = split[0];
    String pass = split[1];

    if (user.equals(username)) { //make sure to  use equals() for Objects
        password = pass;
    }
}