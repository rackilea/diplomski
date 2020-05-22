@Override
public boolean equals(Object o) {
    if(o instanceof Hotdog){
        Hotdog h = (Hotdog)o;
        return ((this.standNumber).equals( h.standNumber)) && ((this.soldToday).equals( h.soldToday))
    }
    return false;
}