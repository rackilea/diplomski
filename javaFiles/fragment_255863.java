public void importFile() {
        //The file variable to be imported.
        File file;

        try {
            //Used to access settings.
            TinyDB database = new TinyDB(getApplicationContext());

            //Sets the file equal to the file found at the specified path.
            String strfilePath = database.getString("FilePath");
            file = new File(strfilePath);

            //To be used to arrange the imported information.
            ArrayList<String> strAcc = new ArrayList<>();
            ArrayList<String> strUser = new ArrayList<>();
            ArrayList<String> strPass = new ArrayList<>();
            ArrayList<String> strAdditionalInfo = new ArrayList<>();

            //To be used to store all the information for additional info variables. This is
            //due to its multi-line nature requiring a slightly different method of
            //importation, the other variables are expected to be one line.
            String strExtraInfo = "";

            //Goes through the file and adds info to arrays for each corresponding variable.
            //If the line does not have an identifier, it assumes it to be an additional
            //info line, and will be processed later.
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                String line;
                String strLine;

                while ((line = br.readLine()) != null) {
                    if (line.contains("[Acc]")) {
                        strLine = line.replace("[Acc]","");
                        strAcc.add(strLine);
                    } else if (line.contains("[User]")) {
                        strLine = line.replace("[User]", "");
                        strUser.add(strLine);
                    } else if (line.contains("[Pass]")) {
                        strLine = line.replace("[Pass]", "");
                        strPass.add(strLine);
                    } else  {
                        strExtraInfo += line;
                    }
                }
            }

            //Gets the list of accounts.
            ArrayList<String> savedInfo = new ArrayList<>(database.getListString("allSaved"));

            //To be used to get the AdditionalInfo variables one line at a time.
            String strSubInfo;

            //Gets rid of any erroneous spaces.
            while (strExtraInfo.contains("  ")) {
                strExtraInfo = strExtraInfo.replace("  ", " ");
            }

            Log.d("STRExtraInfo",strExtraInfo);
            strExtraInfo = strExtraInfo.replace("[ExtraStart]","");
            String array[] = strExtraInfo.split("\\[ExtraEnd\\]");
            ArrayList<String> strRawAdditionalInfo = new ArrayList<>();
            strRawAdditionalInfo = new ArrayList<>(Arrays.asList(array));

            for (String info : strRawAdditionalInfo){
                strAdditionalInfo.add(info);
                Log.d("ExtraInfo",info );
            }

            //Arranges the information.
            for (String name : strAcc) {
                savedInfo.add(name);

                ArrayList<String> allInfo = new ArrayList<>();

                //Gets the info then adds it to database.
                //Deletes the old information.
                if (strUser.size() > 0) {
                    allInfo.add(strUser.get(0));
                    strUser.remove(0);
                }

                if (strPass.size() > 0) {
                    allInfo.add(strPass.get(0));
                    strPass.remove(0);
                }

                if (strAdditionalInfo.size() > 0) {
                    allInfo.add(strAdditionalInfo.get(0));
                    strAdditionalInfo.remove(0);
                }
                database.putListString(name,allInfo);
            }