String command;
            String[] commandArray;


            command = "./new_scripts/setpermission.sh";
            commandArray = new String[]{"/bin/sh", command, fileLocation, permission};
          try {

              Process p = Runtime.getRuntime().exec(commandArray);

         } catch (Exception e) {

            // TODO Auto-generated catch block
            e.printStackTrace();
        }