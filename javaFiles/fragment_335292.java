if (TextUtils.isEqual(storedSender,model.getMessage_sender())){ 
        viewHolder.messageSender.setVisiblity(View.GONE) 
       } 
    else{ 
        // do your normal flow 
        viewHolder.messageSender.setVisiblity(View.VISIBLE); 
    storedSender = model.getMessage_sender(); 
    }