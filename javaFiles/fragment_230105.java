public String Func() {
        Console console = System.console();
        if (console == null)
            throw new IllegalStateException("No console available");

        try {
           String username = console.readLine("Username: ");
           String pwd = new String(console.readPassword("Password: "));
           return pwd;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
}