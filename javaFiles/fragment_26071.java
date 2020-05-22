String searchCmd;
if (System.getProperty("os.name").contains("Windows")) {
    searchCmd = "where";
} else { // I'm assuming Linux here
    searchCmd = "which";
}

ProcessBuilder procBuilder = new ProcessBuilder(searchCmd, "notepad.exe");
Process process = procBuilder.start();

ArrayList<String> filePaths = new ArrayList<String>();
Scanner scanner = new Scanner(process.getInputStream());
while (scanner.hasNextLine()) {
    filePaths.add(scanner.nextLine());
}
scanner.close();

System.out.println(filePaths);