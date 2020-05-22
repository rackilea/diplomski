abstract public class Type {
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Type) {
            return name.equals (((Type)obj).getName());
        }
        return false;
    }   
}