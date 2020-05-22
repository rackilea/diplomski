if (num == 0) {
    final int msgSeqNum = header.getInt(MsgSeqNum.FIELD);
    if (persistMessages) {
        state.set(msgSeqNum, messageString);
    }
    state.incrNextSenderMsgSeqNum();
}