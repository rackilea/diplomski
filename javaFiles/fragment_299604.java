void processLogin(String line) {
    if (user == null) {
        user = line;
    }
    else if (password == null) {
        password = line;
    }
    else {
        if (validUser(user, password)) {
            state = command;
        }
        else {
            socket.close();
        }
    }
}