public static int timeAgoToSeconds(String timeAgo) {
    int timeInSec = 0;
    String []myStringArray = timeAgo.trim().split(" ");

    if(myStringArray.length==3){
     timeInSec = Integer.valueOf(myStringArray[0]) *60;
    }

    if(myStringArray.length==5){
        timeInSec = Integer.valueOf(myStringArray[0]) *3600 + Integer.valueOf(myStringArray[2]) * 60; 
    }

 return timeInSec;