String feedFileName="intusa35a.csv";
        ftp = new FtpProxyClient("server", 21,
                "user", "pass");

        ftp.setBinaryMode();

        ftp.changeDirectory("prxdpshr");

         ftp.getFile(feedFileName);

        ftp.changeDirectory("prxdpshr/archive_bkp");


        is=ftp.isFileExists("intusa35a.csv");

        is1=ftp.isFileExists("HR_Dorf_FeedFile.csv");           


        //lin = new LineNumberReader(new InputStreamReader(is));

        //lin1 = new LineNumberReader(new InputStreamReader(is1));

        String fileName="";
        StringBuffer body1=new StringBuffer();

        for (int i = 4  ; i < 10; i++) {                
            fileName = feedFileName
                    .replace(".", "_" + i + ".");
            if(ftp.isFileExists(fileName)){
                body1.append(fileName); 
            }
            else{
                body1.append(fileName+" (Not Available in archive folder).");
            }

            body1.append("\n");
        }

    }