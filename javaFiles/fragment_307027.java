package forum13232991;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ValueAdapter extends XmlAdapter<Value, Object> {

    @Override
    public Value marshal(Object object) throws Exception {
        Value value = new Value();
        if(object instanceof StructuredValue) {
            StructuredValue structuredValue = (StructuredValue) object;
            value.type = "structured";
            value.components = structuredValue.components;
        } else {
            StringValue stringValue = (StringValue) object;
            value.value.add(stringValue.value);
        }
        return value;
    }

    @Override
    public Object unmarshal(Value value) throws Exception {
        if("string".equals(value.type)) {
            StringValue stringValue = new StringValue();
            StringBuilder strBldr = new StringBuilder();
            for(String string : value.value) {
                strBldr.append(string);
            }
            stringValue.value = strBldr.toString();
            return stringValue;
        } else {
            StructuredValue structuredValue = new StructuredValue();
            structuredValue.components = value.components;
            return structuredValue;
        }
    }

}