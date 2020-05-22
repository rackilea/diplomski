Runtime rt = Runtime.getRuntime();
String setCommand="PGPASSWORD=" + password;

String command = String.format("psql -d %s -h %s -p %s -U %s -w -f %s", 
        database, host, port, user, "create_tables.sql");

String finalCommand = "cmd /c \" " + command +"\"";
System.out.println("Executing command " + finalCommand);

Process p = rt.exec(finalCommand ,new String[]{setCommand});
p.waitFor();