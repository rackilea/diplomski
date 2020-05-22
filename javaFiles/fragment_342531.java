OutputStream os = response.getOutputStream();

    PropertyValue[] properties = new PropertyValue[2];
    PropertyValue property = new PropertyValue();
    property.Name = "FilterName";
    property.Value = FORMAT_WORD_97;
    properties[0] = property;
    PropertyValue streamProp = new PropertyValue();
    streamProp.Name = "OutputStream;
    streamProp.Value = os;
    properties[1] = streamProp;

    storable.storeAsURL("private:stream", properties);