public String getArrival(){
       String curATime =null;
       if(this.arrival!=null)
       {
        curATime = String.format("%02d:%02d",this.arrival.get(Calendar.HOUR_OF_DAY),this.arrival.get(Calendar.MINUTE));             
        }
        return curATime ;    
    }