String  msgString = "<message from='923442621149' id='123' type='chat'><body>shanraisshan</body></message>";
Message message = (Message)PacketParserUtils.parseStanza(msgString);

Log.e("message XML->", message.toXML().toString());
Log.e("message getFrom()->", message.getFrom() + ":"); //923442621149:
Log.e("message getStanzaId()->", message.getStanzaId() + ":"); //123: