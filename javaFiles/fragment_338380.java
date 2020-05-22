for (Message message : messages) {
    if (message.getSentDate().after(minDate) && message.getSentDate().before(maxDate))
       {
          //do whatever you want with your filtered by period message
       } 
}