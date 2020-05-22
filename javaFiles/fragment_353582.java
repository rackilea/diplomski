interface MessageListener {
    void message1(String field2, Object customData, Object otherData);
    void message2(String field2, String field3, Object customData, Object otherData);
    // other message types
}


MessageListener ml = 
String firstField = getField();
switch(firstField) {
    case messageType1: {
        String field2 = getField();
        Object customData = getData();
        Object otherData = getData();
        ml.message1(field2, customData, otherData);
        break;
    }
    case messageType2: {
        String field2 = getField();
        String field3 = getField();
        Object customData = getData();
        Object otherData = getData();
        ml.message2(field2, field3, customData, otherData);
        break;
    }
    //parse other message types

    default:
        // report unknown message type.
}