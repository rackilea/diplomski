while (!found) { 
    for (Cliente c : clientList) {
        userA = c.getUser();
        if (userA.equals(user)) {
            passA = c.getPassword();
            if (passA.equals(pass)) {
                loginOK = true;
                found= true;
                break;
            }
        }
    }
}