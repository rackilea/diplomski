for (Event_BACKUP e : events) {
        // Get a list of stores
        Store store = e.getStore();
        xstream.registerConverter(storeConverter,
                XStream.PRIORITY_VERY_HIGH);
        xstream.alias("row", Store.class);

        storeXml = xstream.toXML(store);
        xml = xstream.toXML(e);
        **xml = combineStrings(xml, storeXml);**

        buffer.append(xml);
    }
    buffer.append( "</rows>" );
    xml = buffer.toString();