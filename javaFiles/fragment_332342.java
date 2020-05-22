public class MyStyle extends CamelCaseStyle{
    @Override
    public String getElement(String name) {
        if( name == null ){
            return null;
        }
        int index = name.indexOf(':');
        if( index != -1 ){
            String theRest = super.getElement(name.substring(index+1));
            return name.substring(0, index+1)+theRest;
        }
        return super.getElement(name);
    }
}