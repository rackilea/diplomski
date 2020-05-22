public void delay(String station,int minute){
String cityDelay=station;
int timeDelay=minute;
boolean updateRest = false;
for(Station list: schedule){
    if (cityDelay.equalsIgnoreCase(list.getCity())){                    
        updateRest = true;          
    }
    if(updateRest){
        Calendar c = list.getArrivalDate();                 
        c.add(Calendar.MINUTE, timeDelay);              
        System.out.println("City: "+list.getCity()+"Updated Arrival time: "+ list.getArrival());  //to see if it updated   
    }
}
updateRest = false;
}