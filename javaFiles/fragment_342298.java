JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.showOpenDialog(null);
        File[] files = chooser.getSelectedFiles();
       // String filename = files.getAbsolutePath();



           for(File f:files){
           FileReader reader = new FileReader(f);
           BufferedReader br = new BufferedReader(reader);
           while( (line = br.readLine()) != null ) {
                jTextArea1.append(line);
           }

           br.close();
           //jTextArea1.requestFocus();
         }