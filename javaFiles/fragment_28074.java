if (SelectRoomActivity.bundle.getBoolean("local")){   //error is generated if condition
    serverAdress = address;   //abc.ddns.net
}
else{
    serverAdress = lan;   //192.168.1.101
}