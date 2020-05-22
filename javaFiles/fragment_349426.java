public Connection.Response getLoginData() {
        Connection.Response res = null;
        try {
            String html;
            int length, counter;

            res = Jsoup
                    .connect("https://bannersbroker.com//user/login?event=doLogin")
                    .execute();

            html = res.parse().toString();
            length = html.length();
            counter = 0;

            for (int i = 0; i < length; i++) {
                if (html.startsWith("document.write", i)) {
                    name[counter] = html.substring(i + 41, i + 144);
                    value[counter] = "Login";
                    counter++;
                }
                if (html.startsWith("hidden", i)) {
                    name[counter] = html.substring(i + 13, i + 81);
                    value[counter] = html.substring(i + 90, i + 123);
                    counter++;
                }
            }

        } catch (IOException ioe) {
        } catch (NullPointerException ioe) {
            JOptionPane.showMessageDialog(RunFrame.getInstance(),
                    "Could not open connection to Banners Broker!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }