String line;
while ((line = in.readLine()) != null) {
    switch (state) {
        case login:
            processLogin(line);
            break;
        case command:
            processCommand(line);
            break;
    }
}