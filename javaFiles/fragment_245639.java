// define backup file
    File fbackup = new File("C:/backup.sql");
    // execute mysqldump command
    String[] command = new String[] {"cmd.exe", "/c", "C:/path/to/mysqldump.exe --quick --lock-tables --user=myuser --password=mypwd mydatabase"};
    final Process process = Runtime.getRuntime().exec(command);
    // write process output line by line to file
    if(process!=null) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    try(BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(process.getInputStream()))); 
                        BufferedWriter writer = new BufferedWriter(new FileWriter(fbackup))) {
                        String line;
                        while((line=reader.readLine())!=null)   {
                            writer.write(line);
                            writer.newLine();
                        }
                    }
                } catch(Exception ex){
                    // handle or log exception ...
                }
            }
        }).start();
    }
    if(process!=null && process.waitFor()==0) {
        // success ...
    } else {
        // failed
    }