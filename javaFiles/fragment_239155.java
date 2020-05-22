public class AccSysChannel extends SwitchChannel implements BlockUntilGetMessageLengthItf{

public static void main(String[] args) {
    new AccSysChannel().init();
}

private void init() {

    BlockUntilGetMessageLengthItf ref  = this;

    new ActiveSocket(ref);      

}

@Override
public int blockUntilGetMessageLength() {
    // TODO Auto-generated method stub
    return 0;
}
}