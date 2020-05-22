public void refresh_receive() throws ExecutionException, InterruptedException {
        String method = "receive_message";
        Receive_Live_Message_Async receive_live_message_async = new Receive_Live_Message_Async(this);
        receive_live_message_async.execute(method, message_id).get();// Setup the message
        // changing here
        dataList.clear();
        dataList.addAdd((ArrayList)MessagingData.getMessageListData())
        adapter.setListData(dataList);
        adapter.notifyDataSetChanged();
        global.setNotification(0);//reset notification
 }