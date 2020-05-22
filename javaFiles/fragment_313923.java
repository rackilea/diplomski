String[][] userPass = { { "user1", "pass1" },
                        { "user2", "pass2" },
                        { "user3", "pass3" } };

String value1 = "userToCheck";
String value2 = "passToCheck";

boolean userOk = false;
for (String[] up : userPass)
    if (value1.equals(up[0]) && value2.equals(up[1]))
        userOk = true;

System.out.println("User authenticated: " + userOk);