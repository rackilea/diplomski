@Entry( objectClasses={"myObject"} )
public class MyDataContainer {

    @Attribute("myattribute")
    private List<String> _myattribute = new ArrayList<String>(1);

    public String getMyAttribute() {
        if ( _myattribute.length() > 0 ) {
            return _myattribute.get(0);
        }
        return null;
    }

    public void setMyAttribute( String value ) {
        _myattribute.clear();
        value = ( value == null ) ? "" : value.trim();
        if ( ! "".equals( value ) ) {
            _myattribute.add( value );
        }
    }
}