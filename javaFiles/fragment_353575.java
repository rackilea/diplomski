int accountIndex = -1;
for (int i = 0; i < accountsList.size(); i++) {
    // Split the current accounts data line into a String Array
    String[] userData = accountsList.get(i).split(",");
    // Check User Name/Password valitity.
    if (userData[1].equals(username) && userData[2].equals(password)) {
        accountIndex = i;
        break;    // Success - We found it. Stop Looking.
    }
}