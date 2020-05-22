private boolean receiveChatMessage() {
        InternalDatabaseOperations DB = new InternalDatabaseOperations(this);
        Cursor CR = DB.getInformation(DB);
        CR.moveToLast();
        from = CR.getString(0);
        to = CR.getString(1);
    if(!Objects.equals(mess, CR.getString(2))){
        mess = CR.getString(2);

        //modified:
        runOnUiThread(new Runnable() {              
          @Override
          public void run() {
            chatArrayAdapter.add(new ChatMessage(!side, mess));
          }
        });

        CR.close(); //close your cursor to avoid memory leaks!
        return true;
    }
    CR.close(); //close your cursor to avoid memory leaks!
    return false;
}