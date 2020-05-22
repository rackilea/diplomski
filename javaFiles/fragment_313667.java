File backupFile = new File("C:/Users/Rohan/Desktop/LMS/backup.sql");
 int len1=backupFile.length();
 FileWriter fw = new FileWriter(backupFile);

 Process child = runtime.exec("C:/Program Files (x86)/MySQL/MySQL Server 5.5/bin/mysqldump --user=root --password=root --lock-all-tables --opt dummy");
        InputStreamReader irs = new InputStreamReader(child.getInputStream());
        BufferedReader br = new BufferedReader(irs);
        String line;
        while( (line=br.readLine()) != null ) {
            fw.write(line + "\n");
        }
        fw.close();
        irs.close();
        br.close(); 

       int len2=backupFile.length();

       int compare=len2-len1;

          if(compare>0)
          {
            System.out.println("-- Backup done---");
          }