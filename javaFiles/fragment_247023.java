protected Subscriber updateSubscriberAttributes(Subscriber subscriber, Collection<SubscriberAttributeDto> subscriberAttributesCollection) throws ErrorException {
    // Do we have any custom attributes to store?
    if ((subscriberAttributesCollection != null) && !subscriberAttributesCollection.isEmpty()) {
        // Yes! Convert to a Map first.
        Map<String, List<Object>> subscriberAttributesMap = new HashMap<String, List<Object>>(subscriberAttributesCollection.size());
        for (SubscriberAttributeDto subscriberAttribute : subscriberAttributesCollection) {
            // Convert the input attribute value to a database-appropriate value
            SubscriberAttributeMetadata attrMetadata = subscriberAttribute.getAttributeMetadata();
            if (attrMetadata != null) {
                //
                String columnName = attrMetadata.getColumnName();
                List<Object> list = subscriberAttributesMap.get(columnName);
                if (list == null) {
                    list = new ArrayList<Object>();
                    subscriberAttributesMap.put(columnName, list);
                }
                //
                list.add(attrMetadata.convertToDatabaseValue((String) subscriberAttribute.getValue()));
            }
        }

        // Perform the update
        return updateSubscriberAttributes(subscriber, subscriberAttributesMap);
    } else {
        return subscriber;
    }
}

protected Subscriber updateSubscriberAttributes(Subscriber subscriber,  Map<String, List<Object>> map) throws ErrorException {
    // do some logic hiere ...
    return new Subscriber();
}