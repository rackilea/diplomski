list_item.addListSelectionListener(new ListSelectionListener() {

    @Override
    public void valueChanged(ListSelectionEvent arg0) {
        try{
                 BufferedReader br = new BufferedReader(new FileReader("C:\\myfile.txt"));
                 String line;  
                 while ((line = br.readLine())!= null) 
                  {  
                  // read file line by line here  
                  your_text_area.append(line+"\n");

                 } 
                 }catch(Exception e){
                     e.printStackTrace();
                 }
    }
});