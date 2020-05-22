@Override
  protected Integer doInBackground() throws Exception {
    try {
            BufferedReader reader = new BufferedReader(new FileReader(myFile));
            myHash = new HashOA(300000);
           try {
               while(reader.readLine() != null){
                   myHash.hash(reader.readLine());
               }

               return null;

           } catch (IOException ex) {
               Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
           }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void done() {
        consoleArea.append("\n" + myFile.getName() + " is successfully hashed!!");
    }