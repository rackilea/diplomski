for(int i=0 ;i < risposta.length() - 3 ;i++){
    if(risposta.charAt(i) != '0') {
        crc= Character.toString(risposta.charAt(i + 3)) + Character.toString(risposta.charAt(i+2)) + Character.toString(risposta.charAt(i+1)) + Character.toString(risposta.charAt(i));
        break;
    } 
}