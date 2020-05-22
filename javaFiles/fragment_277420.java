final CallBackListener cbl = this;

final Button post_btn = (Button) findViewById(R.id.post_btn);
post_btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        EditText post_text = (EditText) findViewById(R.id.post_text);

        if (!post_text.isEmpty()) {
            my_random_task = new MyRandomTask();
            my_random_task.setListener(cbl);
            summoner_search_task.execute(summoner_name);
        }else{
            Toast.makeText(getApplicationContext(), "Please type a post text.", Toast.LENGTH_SHORT).show();
            post_text.requestFocus();
        }

    }
});