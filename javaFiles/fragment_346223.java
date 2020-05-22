try{    
        Process p = Runtime.getRuntime().exec("C:\\R\\R-3.2.0\\bin\\Rscript.exe C:\\dir\my_script.R");

        int processComplete = p.waitFor();

           if (processComplete == 0) {
                System.out.println("successfull");
           } else {
                System.out.println("Could not complete");
           }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }