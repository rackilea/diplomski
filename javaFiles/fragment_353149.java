interface Operation<T> {
    public T run(); 
}

public enum Something {
    KIMURA1980("kimura1980()", new Operation<SerializedExpFamMixture>() {
                                      public SerializedExpFamMixture run() { 
                                          return SerializedExpFamMixture.kimura1980();
                                      } 
                               }) ,
    ACCORDANCE("accordance()", new Operation<SerializedExpFamMixture>() {
                                       public SerializedExpFamMixture run() { 
                                           return SerializedExpFamMixture.accordance();
                                       } 
                               }),
    PAIR("pair()", new Operation<SerializedExpFamMixture>() {
                           public SerializedExpFamMixture run() { 
                               return SerializedExpFamMixture.pair();
                           } 
                   }),
    DEFAULT(null, new Operation<SerializedExpFamMixture>() {
                          public SerializedExpFamMixture run() { 
                              return new SerializedExpFamMixture();
                          } 
                  });

    private final String stringValue;
    private final Operation<SerializedExpFamMixture> operation;

    private Something(final String stringValue, final Operation<SerializedExpFamMixture> operation) {
        this.stringValue = stringValue;
        this.operation = operation;
    }

    public static Something fromString(final String string) {
        if (string != null) {
            for (final Something something : values()) {
                if (string.equals(something.stringValue)) {
                    return something;
                }
            }
        }
        return DEFAULT;
    }

    public SerializedExpFamMixture getCorrespondingSerializedExpFamMixture() {
        return operation.run();
    }
}