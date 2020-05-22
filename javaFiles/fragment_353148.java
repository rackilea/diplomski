public enum Something {
    KIMURA1980("kimura1980()"),
    ACCORDANCE("accordance()"),
    PAIR("pair()");

    private final String stringValue;

    private Something(final String stringValue) {
        this.stringValue = stringValue;
    }

    public static Something fromString(final String string) {
        for (final Something something : values()) {
            if (something.stringValue.equals(string)) {
                return something;
            }
        }
        return null;
    }
}

public static SerializedExpFamMixture rateMtxModel(final String model) {
   if (model == null) {
       throw new IllegalArgumentException("model is null!");
   }

   final Something something = Something.fromString(model);

   if (something == null) {
      return new SerializedExpFamMixture();
   }

   switch(something) {
       case KIMURA1980:
           return SerializedExpFamMixture.kimura1980();
       case ACCORDANCE:
           return SerializedExpFamMixture.accordance();
       case PAIR:
           return SerializedExpFamMixture.pair();
       default:
           return new SerializedExpFamMixture();    
   }   
}