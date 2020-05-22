public Connection.Response doLogin(Connection.Response res, String email, String pass) {
        Connection.Response res2 = null;
        try {
            res2 = Jsoup
                    .connect("https://bannersbroker.com//user/login?event=doLogin")
                    .cookies(res.cookies())
                    .data("email", email)
                    .data("pass", pass)
                    .data(name[0], value[0])
                    .data(name[1], value[1])
                    .data(name[2], value[2])
                    .method(Connection.Method.POST)
                    .execute();

        } catch (IOException ioe) {
        } catch (IllegalArgumentException ioe) {
            JOptionPane.showMessageDialog(RunFrame.getInstance(),
                    "Could not open connection to Banners Broker!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException ioe) {
            JOptionPane.showMessageDialog(RunFrame.getInstance(),
                    "Could not open connection to Banners Broker!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return res2;
    }