public class ActiveSocket{

public ActiveSocket(BlockUntilGetMessageLengthItf ref) {
    // call local
    blockUntilGetMessageLength();

    // call to AccSysChannel  
    ref.blockUntilGetMessageLength();
}

private int blockUntilGetMessageLength(){
    // ....
    return 0;
}
}