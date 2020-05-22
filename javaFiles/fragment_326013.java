public class Login {
    static Scanner s = new Scanner(System.in);
    static Scanner read;
    private static Formatter x;

    public static void main(String args[]) {    
        try {
            x = new Formatter("DataBase.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        do {
            System.out.println("Type LOGIN to login, Type REGISTER to register");
            if (s.next().equals("REGISTER")) {
                System.out.println("Insert username");
                String userName = s.next();
                while (exists(userName) == true) {
                    System.out.println("ERROR! username already exists");
                    System.out.println("please selcet a different username");
                    userName = s.next();
                }
                System.out.println("username is legal");
                System.out.println("Insert password");
                String passWord = s.next();
                while (exists(passWord)) {
                    System.out.println("ERROR! password already exists");
                    System.out.println("please selcet a different password");
                    passWord = s.next();
                }
                x.format("%s%s%s%s", userName,
                        System.getProperty("line.separator"), passWord,
                        System.getProperty("line.separator"));
                System.out.println("User created");
                System.out
                        .println("Type continue to continue, or stop to close");
                x.flush();
            }
        } while (s.next().equals("continue"));

        x.close();

    }

    public static Boolean exists(String str) {
        try {
            read = new Scanner(new File("DataBase.txt"));
            while (read.hasNext()) {
                String data = read.next();
                System.out.println(data);
                if (data.equals(str)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            read.close();
        }
        return false;
    }

}