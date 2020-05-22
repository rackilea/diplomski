for (int line = 0; line < list.size(); line++) {
    String[] parts = list.get(line).split(" ");
    String username = parts[0];
    String pass = parts[3];
    System.out.println("Line" + (line + 1) + ": " + "User is " + username +" and password is " + pass);
}