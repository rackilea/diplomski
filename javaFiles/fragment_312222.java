public void initListeners(){
    chooseFile.addActionListener(e -> {
        JFileChooser fs=new JFileChooser(new File("C:\\"));
        fs.setDialogTitle("Choose document to change");
        fs.setFileFilter(new FileTypeFilter(".txt"," New Text Document"));
        int result=fs.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
            BufferedReader br;
            String fulltext=" ";
            try {
                File fi=fs.getSelectedFile();
                br=new BufferedReader(new FileReader(fi.getPath()));
                String line;

                int i=0;
                while((line=br.readLine())!=null){
                    fulltext+=line+"\r\n";
                }
                br.close();
                fulltext=fulltext.replace("text","cs101");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, e.getMessage() );
            }catch(IOException ex){
                JOptionPane.showMessageDialog(null, ex.getMessage() );
            }
            PrintWriter input;
            try {
                upis=new PrintWriter(new FileWriter(fi.getPath));
                upis.append(fulltext);
                upis.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage() );
            }
        }
    });
}