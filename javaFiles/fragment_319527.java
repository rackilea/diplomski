class D {

    /*public <T extends Super> would be muuuch nicer here as well!*/
    public /*static*/ <T> void change_footer(T obj, int data) {
        //otherwise, you could just cast to Super...and set dat field.
        if (obj instanceof A) {
            ((A) obj).setField(data);
        } else if (obj instanceof B) {
            ((B) obj).setField(data);
        } // else ... ?

    }
}