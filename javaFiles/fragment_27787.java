public boolean create(Device d) {
        BasicDBObject document = new BasicDBObject();
        document.put("UDID",d.UDID);
        document.put("name", d.FriendlyName);
        document.put("Serial", d.sn);
        document.put("Manf", d.ManDate);
        collection.insert(document);
        return true;
}