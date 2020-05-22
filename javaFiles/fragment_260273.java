@Override 
public Object clone() throws CloneNotSupportedException {   
    //get initial bit-by-bit copy, which handles all immutable fields
    Fruit result = (Fruit)super.clone();

    //mutable fields need to be made independent of this object, for reasons
    //similar to those for defensive copies - to prevent unwanted access to
    //this object's internal state
    result.fBestBeforeDate = new Date( this.fBestBeforeDate.getTime() );

    return result;
}