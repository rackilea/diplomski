@Override
public boolean equals(Object obj){

    if(obj instanceof HotelRoom) {
       if( Math.abs(this.rateperNight - ((HotelRoom) obj).rateperNight) < .000001) {
            return true;
       }
    }
    return false;
}