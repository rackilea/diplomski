try{
    fw = new FileWriteroutput_filename,false);
    bw= new BufferedWriter(fw);
    for(String i : output_list){
        bw.write(i);
        bw.newLine();
    }
}
catch(IOException e){}