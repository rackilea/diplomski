System.out.print("Press 1 for Normal or 2 for Keygen - " + client);
String mode = input.nextLine().trim();

if (mode.equals("1")) {
    final String location = "C:\\WINDOWS\\system32";
    Runtime rt = Runtime.getRuntime();
    rt.exec("cmd.exe /c start dir /p", null, new File(location));
} else if (mode.equals("2")) {
} else {
    System.out.println("Option not recognised");
}