String[] faults = { "Misspelled", "Error", "Fixed", "Change","Update", "Out of sync",
"Fail", "API Tooling","Unclear", "Charset", "Typos", "Fixed bug"};
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Azad.txt"));
            String line = reader.readLine();
            while(line !=null)
            {
               for(int i = 0 ; i<faults.length;i++){
               if(line.contains(faults[i])){
                   // do something
                   System.out.println(faults[i]);
               }
               }
               line=reader.readLine();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }