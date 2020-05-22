public static SerializedExpFamMixture rateMtxModel(String model) {
   if (model.equals("kimura1980()")) {
     return SerializedExpFamMixture.kimura1980();
   } else if (model.equals("accordance()")) {
     return SerializedExpFamMixture.accordance();
   } else if(model.equals("pair()")) {
     return SerializedExpFamMixture.pair();
   } 
   return new SerializedExpFamMixture();
}