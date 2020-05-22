String s=file.getAbsolutePath() + "\\compile.bat";
Runtime rut = Runtime.getRuntime();
try {
    Process process = rut.exec(new String[] {file.getAbsolutePath() + "\\compile.bat"});
    // prints out any message that are usually displayed in the console
    Scanner scanner = new Scanner(process.getInputStream());
    while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
    }
}catch(IOException e1) {
    e1.printStackTrace();
}
System.out.println(s);