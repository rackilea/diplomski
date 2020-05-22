int counter = 0;
while(counter * 8 < encodedData.length()){
    int index = counter * 8;
    String str = encodedData.substring(index, index + 8);
    eData += str;
    if(!str.equals("00000000")){
        encodedMessage += new Character((char)Integer.parseInt(str, 2)).toString();
        counter++;
    }
    else{
        eData = eData.substring(0,eData.length()-8);
        break;
    }
}