while(true){
    try {
        String msg = dis.readUTF();
        textArea.append("From Client :- "+msg+"\n");
    }catch(Exception e){e.printStackTrace();}       
}