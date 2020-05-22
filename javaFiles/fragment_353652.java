String dbName = "";
            String dbUser = "";
            String dbPass = "";
            String dbh = "";
            String dbport = "";
            Connection connection;


//userPathForDbBackup is user selected path from file chooser


            String pathFinal=userPathForDbBackup + "\\Backup_" + name + ".sql";
            System.out.println(userPathForDbBackup+"before");
            userPathForDbBackup= userPathForDbBackup+"\\Backup_name.sql";
            System.out.println(userPathForDbBackup+"after");

            String folderPath = userPathForDbBackup.substring(0, userPathForDbBackup.lastIndexOf("\\")) ;


            File path =new File(userPathForDbBackup);

            String[] executeCmd = new String[]{"C:/Program Files/MySQL/MySQL Server 5.6/bin/mysqldump.exe", "--user=" + dbUser, "--password=" + dbPass,""+ dbName,"-r"+path};

            try{

                connection = create_connection.jdbc.getCon();

                if(connection!=null){
                    Process runtimeProcess =Runtime.getRuntime().exec(executeCmd);
                    int processComplete = runtimeProcess.waitFor();
                    if (processComplete != 0) { //4
                        // something went wrong
                        InputStream errorStream = runtimeProcess.getErrorStream();
                        byte[] buffer = new byte[errorStream.available()];
                        errorStream.read(buffer);

                        System.out.println(new String(buffer));
                    }
                } else{
                    System.out.println("connection not sucess");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }