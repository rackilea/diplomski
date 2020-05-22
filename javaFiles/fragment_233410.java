public boolean evaluate( Object obj ) {
        boolean match = false;
        if( obj instanceof MyObject ) {
            if( "objectA".equals( ((MyObject)obj).typeOfObject ) 
            && 1 == ((MyObject)obj).anInteger ) {
                match = true;
            }
        }
        return match;
    }