public class EntityAdapter {
    public MyEntityType unmarshal(EntityComplexType v){
        // ...
        return new MyEntityType();
    }
    public EntityComplexType marshal(MyEntityType v){
        EntityComplexType ect = new EntityComplexType();
        ect.setType( v.getClass().getSimpleName() );
        FieldsComplexType fct = new FieldsComplexType();
        ect.setFields( fct );
        FieldComplexType field1 = new FieldComplexType();
        fct.getField().add( field1 );
        field1.setName( "myField1" );
        for( String s: v.getMyField1() ){
            field1.getValue().add( s );
        }
        FieldComplexType field2 = new FieldComplexType();
        fct.getField().add( field2 );
        field2.setName( "myField2" );
        for( String s: v.getMyField2() ){
            field2.getValue().add( s );
        }
        return ect;
    }
}