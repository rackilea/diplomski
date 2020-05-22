if(button1.isSelected());               
            String path = "C:\\Test\\testlog.txt";
            String mylog = "\r\n"+"Sample Value: " + label1.getText()+"  Sample Value2: "+field1.getText();
            File file = new File(path);
            FileWriter writer;

            try {   
            writer = new FileWriter(file,true);             
            BufferedWriter buffer  = new BufferedWriter(writer);
            writer.append(mylog);                              
            buffer.close();

            }catch (IOException e1) {                           
            label2.setText("Make Sure Path exists, C:\\Test\\testlog.txt");