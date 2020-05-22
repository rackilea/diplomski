new MyAsyncTask(new MyAsyncTask.OnRoutineFinished() {
        @Override
        public void onFinish() {
             CreateEvent.createEventDialog(context, point.getX(),
                    point.getY(), eventAddress);  //this will be called after the task finishes
        }
    }).execute(eventModel);