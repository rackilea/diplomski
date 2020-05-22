public void addData(){
    final DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
    new Thread(new Runnable(){
        public void run(){
            FileInputStream fstream = null;
            try {
                fstream = new FileInputStream("\\data.txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
                String line;
                while((line = br.readLine()) != null){
                    final String ln = line;
                    SwingUtilities.invokeAndWait(new Runnable(){
                        // run on EDT thread.
                        public void run(){
                            model.addRow(new Object[]{ln});
                        }
                    }); 
                    synchronized(Thread.currentThread()){
                        Thread.currentThread().wait(2000);// pause for 2 second.
                    }
                }
            } catch (FileNotFoundException ex) {
                ...
            } catch (IOException ex) {
                ....
            } finally {
                if(fstream!=null){
                    try{
                        fstream.close();
                    }catch (IOException e) {
                        ....
                    }
                }
            }
        }
    }).start();
}