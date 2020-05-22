// I've hardcoded balance here as an example.
    int balance = 55 * 100; 
    int total = 65535;
    int diference = total - balance;

    // You don't need to call toString() here because
    // toHexString()'s output is already a String.
    String StrBalance = Integer.toHexString(balance);      //"157c"
    String StrDiference  = Integer.toHexString(diference); //"ea83"

    String sub;
    byte a = Byte.decode("0x"+StrBalance.substring(2));    //OK, 0x7c=124
    byte b = Byte.decode("0x"+StrBalance.substring(0,2));  //OK, 0x15=21
    sub = StrDiference.substring(2); //"83"
    byte c;
    try {
        c = Byte.decode("0x"+sub);   //NG, because 0x83=131 > 127
    } catch (NumberFormatException e) {
        c = 0; //Byte.decode will throw a NumberFormatException
    }