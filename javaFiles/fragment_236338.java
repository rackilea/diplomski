Scanner sc = new Scanner(System.in);
String name = sc.next();
String[] methods = name.split("\\|");

for (String method : methods) {
    switch(method) {
        case "a":
            a();
            break;

        case "c":
            c();
            break;

        default:
            System.out.println("No method " + method + "() is known to exist");
            break;
    }
}