@Override
public Object deserialize(PofReader reader) throws IOException {

    BasicTypes basic = new BasicTypes();

    basic.number2 = (Number[]) reader.readObjectArray(NUMBER2, new Number[0]);
    basic.string2 = (String[]) reader.readObjectArray(STRING2, new String[0]);
    basic.obj2 = (Serializable[]) reader.readObjectArray(OBJECT2, new Serializable[0]);

    reader.readRemainder();
    return basic;
    }
}