public static long getMsFromString(String str) {
    String[] arr = str.split(" ");
    long auctionTimeLeft = 0;
    for(String s : arr){
        if(s.contains("g")) { //convert days to milliseconds
            auctionTimeLeft += Long.parseLong(s.substring(0, s.indexOf("g"))) * 8.64e7;
        }
        else if(s.contains("h")){ //convert hours to milliseconds
            auctionTimeLeft += Long.parseLong(s.substring(0, s.indexOf("h"))) * 3.6e6;
        }
        else if(s.contains("m")){ //convert minutes to milliseconds
            auctionTimeLeft += Long.parseLong(s.substring(0, s.indexOf("m"))) * 60000;
        }
    }
    return auctionTimeLeft;
}