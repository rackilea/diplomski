public class ClientKey {
   ...
   private final ImmutableMap<String, String> parameterMap;

   public ClientKey(Builder builder) {
       ...
       this.parameterMap = builder.parameterMap.build();
       ...
   }

   public static class Builder {
        ...
        protected ImmutableMap.Builder<String, String> parameterMap = ImmutableMap.builder();

        public Builder parameterMap(Map<String, String> parameterMap) {
            this.parameterMap.putAll(parameterMap);
            return this;
        }

        public Builder addParameter(String key, String value) {
            this.parameterMap.put(key, value);
            return this;
        }
     }
 }