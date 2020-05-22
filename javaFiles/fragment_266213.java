final String msgType = msg.getHeader().getString(MsgType.FIELD);
if(MsgType.LOGON.compareTo(msgType) == 0)
{
    msg.setString(quickfix.fields.Username.FIELD, _username);
    msg.setString(quickfix.fields.Password.FIELD, _password);
}