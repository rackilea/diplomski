public static boolean command(String host) {
    try {

        String command = "security find-internet-password -gs " + host;
        Process child = Runtime.getRuntime().exec(command);

        try (BufferedReader out = new BufferedReader(new InputStreamReader(
                child.getInputStream()));
                BufferedReader err = new BufferedReader(
                        new InputStreamReader(child.getErrorStream()))) {
            String user = null;
            String password = null;
            String s;

            while ((s = out.readLine()) != null) {
                if (s.matches(" *\"acct\".*")) {
                    user = s.replaceAll("^.*=\"", "").replace("\"", "");
                }
            }
            s = err.readLine();
            password = s.replaceAll("^.*: *\"", "").replace("\"", "");
            System.out.println("user: " + user);
            System.out.println("pwd: " + password);
            return true;
        }
    } catch (IOException e) {
        return false;
    }
}