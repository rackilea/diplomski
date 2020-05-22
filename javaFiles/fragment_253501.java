String[] executeCmd = new String[]{
    "mysqldump", "--where=" + where_filter, "-u" + userName, "-p" + password, 
    "--skip-add-drop-table", "--no-create-info", "--no-create-db", "-B", dbName, 
    "--tables", tableName, "--result-file=" + path
};
ProcessBuilder builder = new ProcessBuilder(executeCmd);
builder.redirectErrorStream(true);
Process runtimeProcess;
try {

    runtimeProcess = builder.start();
    InputStream processInputStream = process.getInputStream();
    int processComplete = runtimeProcess.waitFor();
    if (processComplete == 0) {
        System.out.println("Backup created successfully");
        return true;
    } else {
        System.out.println("Could not create the backup");                
    }
    BufferedReader reader = new BufferedReader(new InputStreamReader(processInputStream));
    System.out.println("output: ");
        while (reader.ready()) {
            System.out.println(reader.readLine());
        }
} catch (Exception ex) {

}
return false;