private void loadQuestion(){
   Task task = tasks.get(currentTaskId);
   task_question.setText(task.getSoal());
   choice_A.setText(task.getOption_A());
   choice_B.setText(task.getOption_B());
   choice_C.setText(task.getOption_C());
   choice_D.setText(task.getOption_D());
   next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //check task answer, if task was answered correct than score+=10
            if(currentTaskId<tasks.size()){
               currentTaskId++;
               loadQuestion();
            } else {
               //open new activity
            }
        }
    });
    previous.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(currentTaskId>0){
               currentTaskId--;
               loadQuestion();
            } else {
               //do nothing as we are already on the first question
            }
        }
    });
}