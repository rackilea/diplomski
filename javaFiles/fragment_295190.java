for (int i = 0; i < 11; i++) {
    Message msg = mHandler.obtainMessage(MY_MESSAGE_ID, i, 0);
    msg.sendToTarget();

    //  Delay or otherwise wait
}