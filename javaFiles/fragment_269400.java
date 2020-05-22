@Override
public void onResume(){
    super.onResume();

    Bundle bundle = getIntent().getExtras();
    if(bundle != null){
        toUsername.setText("" + bundle.get("ToUsername").toString());
        c_id = new StringBuilder(bundle.get("c_id").toString());
        from_user_id = new StringBuilder(bundle.get("FromUserId").toString());
        //list.add(c_id.toString());
        //list.add(from_user_id.toString());
    }

    myAdapter = new MessageListViewAdapter(getBaseContext(),c_id.toString(),from_user_id.toString());
    listView.setAdapter(myAdapter);

    callAsynchronousTask();
    //myAdapter.add(list);
}
@Override
public void onPause(){
    super.onPause();
    timer.cancel();
}
public void callAsynchronousTask() {
    final Handler handler = new Handler();
    timer = new Timer();
    TimerTask doAsynchronousTask = new TimerTask() {
        @Override
        public void run() {
            handler.post(new Runnable() {
                public void run() {
                    //list.clear();
                    try{
                        resultChatObject = new HttpTask(getBaseContext()).doInBackground("sendMessages",c_id.toString(),String.valueOf(cr_id));
                        if(resultChatObject.get("status").toString().equals("true")) {
                            //list.clear();
                            messages = resultChatObject.getJSONArray("messages");
                            Log.d("Messages: ",messages.toString());
                            for (int i = 0; i <= messages.length(); i++) {
                                list.add(messages.getJSONObject(i).get("reply_text").toString());
                                if (cr_id < Integer.parseInt(messages.getJSONObject(i).get("cr_id").toString()))
                                    cr_id = Integer.parseInt(messages.getJSONObject(i).get("cr_id").toString());
                            }
                        }
                    }
                    catch (JSONException e) { }

                    myAdapter.add(list);
                }
            });
        }
    };
    timer.schedule(doAsynchronousTask, 0, 10000); //execute in every 10000 ms
}