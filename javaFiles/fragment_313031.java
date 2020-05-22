try{
    byte[] bfr=new byte[50];

    FileInputStream IPS=new FileInputStream(COL_PTH);
    int tn=0;
    int nread=0;

    while((nread=IPS.read(bfr))!=-1){
       String clr=new String(bfr);          
       flag=clr;
     } 
            IPS.close();
}
catch(FileNotFoundException fe){
    System.out.println("ERR:9"+fe);
}
catch(IOException IOe){
    System.out.println("ERR:10"+IOe);
}

if(flag=="True"){

 // type your code for showing some text,or whatever it is.


try{

        FileWriter FW=new FileWriter(FLAG_PTH);
        BufferedWriter BF_Wr=new BufferedWriter(FW);
        BF_Wr.write("TRUE");
        BF_Wr.close();

    }
    catch(IOException e){
        System.out.println("ERR:06"+e);
    }
}
else {
     //hide text and go through normal open
}