static Map<Class,Integer> parseId = new HashMap<>();
static {
    parseId.put(AccessErrorException.class, 1);
    parseId.put(DbxApiException.class, 2);
    ...
}
...
public void parseDBX(DbxException e) {
    Integer id = parseId.get(e.getClass());
    if (id != null) {
        switch (id.intValue()) {
            ...
        }
    }
}