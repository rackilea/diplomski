ManagerConnection c = null;
    CommandAction commandAction;
    CommandResponse response = null;
    try {
        c = new ManagerConnectionFactory("127.0.0.1", 5038, "username", "password")
                .createManagerConnection();
        c.login();
        commandAction = new CommandAction(command);
        response = (CommandResponse) c.sendAction(commandAction);
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (TimeoutException e) {
        e.printStackTrace();
    } catch (AuthenticationFailedException e) {
        e.printStackTrace();
    }
    for (String line : response.getResult()) {
        System.out.println(line);
    }