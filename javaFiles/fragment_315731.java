public class Group { 
    //lots of really great code that defines a Group
    public boolean equals(Object obj) {
        if( Object == null ) return false; 
        if( !(Object instanceof Group) ) return false; 
        if( this == obj ) return true; 

        Group compareMe = (Group)obj; 
        if( this.getId() != null && compareMe.getId() != null && this.getId().equals(compareMe.getId()) ) return true; 
        return false; 
    }
}