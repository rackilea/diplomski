final Hanlder hanlder=new Hanlder();
btnGetDirection.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {

           GetEventDirectionAsyncTask obj= new GetEventDirectionAsyncTask(
                    new GetEventDirectionAsyncTask.OnRoutineFinished() {
                        public void onFinish() {
                           ...
                        }
                    },hanlder).execute(eventModel);
        }
    });