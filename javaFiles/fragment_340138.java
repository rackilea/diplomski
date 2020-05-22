public class AliasToMapTransformer extends BasicTransformerAdapter {

    private Map<String, String> renameAliasMap;


    public AliasToMapTransformer(Map<String, String> renameAliasMap) {
        this.renameAliasMap = (renameAliasMap == null) ? Collections.<String, String>emptyMap() : renameAliasMap;
    }


    @Override
    public Object transformTuple(Object[] tuple, String[] aliases) {
        Map<String, Object> result = new HashMap<String, Object>(tuple.length);
        for (int i = 0; i < tuple.length; i++) {
            String alias = aliases[i];
            if (alias != null) {
                String newAlias = renameAliasMap.get(alias);

                result.put((newAlias != null) ? newAlias : alias, tuple[i]);
            }
        }
        return result;
    }


    public static Builder renameAlias(String alias, String newAlias) {
        return new Builder().renameAlias(alias, newAlias);
    }


    public static class Builder {

        private Map<String, String> aliasConversionMap = new HashMap<String, String>();


        public Builder renameAlias(String alias, String newAlias) {
            aliasConversionMap.put(alias, newAlias);
            return this;
        }


        public AliasToMapTransformer build() {
            return new AliasToMapTransformer(aliasConversionMap);
        }
    }
}