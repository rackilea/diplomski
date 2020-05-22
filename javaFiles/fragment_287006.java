public class VssKey {

     // getterrs
     // setters
     // equals
     // hashcode
}

    MultiValuedMap<VssKey, String> partNumberVarientMap = new ArrayListValuedHashMap<>();

            for (SummaryDataOracle summaryDataOracle : summeryDataOracleList) {

                VssKey key = new VssKey(summaryDataOracle);

                String varntText = null;
                if (!StringUtils.isEmpty(summaryDataOracle.getVariantSmText())) {
                    varntText = summaryDataOracle.getVariantSmText().trim();
                }

                partNumberVarientMap.put(key, varntText);    
}