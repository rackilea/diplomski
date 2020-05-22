CallAPI asyncTask = new CallAPI(getContext());
CallAPI asyncTask2 = new CallAPI(getContext());
final chat text = this;
  sendb.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            try {
                String data = null;

   //data to send

                CallAPI asyncTask = new CallAPI(getContext());
                asyncTask.delegate = text;
                asyncTask.execute("", data, "sendMsg");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }


           }
sendb2.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {

            try {
                String data = null;

   //data to send

                CallAPI asyncTask2 = new CallAPI(getContext());
                asyncTask2.delegate = text;
                asyncTask2.execute("", data, "sendMsg");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    });


  @Override
    public void onTaskCompleted(String output, String output2) {
}