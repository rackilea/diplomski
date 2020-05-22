for(int i=0; i< myHouse.length; i++){
    if(myHouse[i]!=null){
        textArea.append("Year: ");
        textArea.append(Integer.toString(myHouse[i].getYear()));
        textArea.append(".  Size: ");
        textArea.append(Integer.toString(myHouse[i].getSize()));
        textArea.append("\n");
    }
}