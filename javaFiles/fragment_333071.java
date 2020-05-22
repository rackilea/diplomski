String yourstring = "your text";
List<Status> statusList = twitter.getUserTimeline(userAccount);
 for (Status status : statusList) {
  if(status.getText().toLowerCase().contains(yourstring)){
    System.out.println(status.getUser().getName() + " : " + status.getText());
  }
 }