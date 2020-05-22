@Entity
public class Container {

    private String _value;

    @Column
    public String getValue()
    {
        return _value;
    }

    public void setValue( String value )
    {
        this._value = value;
    }

}