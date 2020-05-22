public String CallEncrypt(String val){

    String send_val = val;
//Call Encrypt Method   
    Encrypt(ref send_val);

//Get Value
    String output = send_val;  
//Pass value to Java Class  
    return output;
}