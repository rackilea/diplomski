public static void main( String[] args )    
{       
    try{    
        String data = " Thank you very much";    

        File file =new File(" ");    

        //if file doesnt exists, then create it    
        if(!file.exists()){    
            file.createNewFile();    
            System.out.println("New File Created Now");    
        }    

        //true = append file    
            FileWriter fileWritter = new FileWriter(file,true);        
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(data);
            bufferWritter.close();
            fileWritter.close();

        System.out.println("Done");    

    }catch(Exception e){    
        e.printStackTrace();    
    }    
}