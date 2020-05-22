public void handleMessage(byte[] msg, int off){
    if(msg.length()-off < 14){//just use the first 14 after offset          System.out.println("Error: Telegram length.");
        return;
    }
    if(msg[0+off]!=0xa5 || msg[0+off]!=0xa5 ){
        System.out.println("Error: Sync Bytes.");
        return;
    }
    //Determine tpye
    switch(msg[2+off]){
    case 0x0b:
        if(msg[3+off]==0x05){

            if(msg[4+off]==0x0b){
            }

        }
        break;
    case 0x6b:
        if(msg[3+off]==0x05){

            if(msg[4+off]==0x0b){

            }
        }
        break;
    case 0x4b:
        //...
        break;
    case 0xab:
        //...
        break;
    default:System.out.println("Error: telegram type");
        break;
    }
}