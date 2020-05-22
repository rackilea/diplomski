boolean userExists = false;
while (y.hasNext()) {
  // .....
  if((a == null ? user2 == null : a.equals(user2)) && b == pass2)
    userExists = true;

  // ...
}

if (userExists)
  System.out.println("Welcome");
else
  System.out.println("Wrong username or password .. try again !!");