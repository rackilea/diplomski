Message message2 = new Message();
    message2.Message = "MSG2";
    message2.senderID = "Sender2";
    message2.recipientID = "Me";
    message2.isRead = true;

    msgList.add(message1);
    msgList.add(message2);
    Log.e("Message 1", message1.Message);
//here also, you were using message 1
    Log.e("Message 2", message2.Message);