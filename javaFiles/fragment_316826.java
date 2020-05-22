private final static int TOAST_MSG_ID_1 = 1;
private final static int TOAST_MSG_ID_2 = 2;
private final static int TOAST_MSG_ID_3 = 3;
// declare a Handler as an instance variable
Handler msgHandler = new Handler(){
    @Override
    public void handleMessage(Message msg) {
            switch(msg.what()) {
                case TOAST_MSG_ID_1:
                    Toast.makeText(...msg1...).show();
                break;
                case TOAST_MSG_ID_2:
                    Toast.makeText(...msg2...).show();
                break;
                .... other messages follow....
            }
    }
};

// and you will use the following to show a Toast message:
msgHandler.sendEmptyMessage(TOAST_MSG_ID_1);
msgHandler.sendEmptyMessage(TOAST_MSG_ID_2);
msgHandler.sendEmptyMessage(TOAST_MSG_ID_3);
...