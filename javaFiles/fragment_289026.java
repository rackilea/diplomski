int index = reminderTableScrollView.getChildCount();
    reminder.setTag(index);
    reminder.setOnClickListener(new OnClickListener(){
        public void onClick(View v){
            // The View you get here is actually the reminder
            int index = (Integer)reminder.getTag();
            // Now you have the index, you can do what you want.
        }
    });
    reminderTableScrollView.addView(reminder);