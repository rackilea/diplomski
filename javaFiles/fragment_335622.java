public static Chain1 createChain1(InputStream in, RepeatableData[] data){
    if(data == null || data.length == 0){
        // handle invalid params
    }
    InputStream nextStream = in;       
    for (int i = 0; i < data.length; i++) {
        nextStream  = new Chain1(nextStream, data[i]);           
    }
    return (Chain1)nextStream;
}