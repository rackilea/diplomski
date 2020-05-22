MapStructure structure = MapStructure.create(HashMap.class, String.class, Object.class);
if(PowerPreference.getFileByName(powerPrefFile).contains(powerPrefMat)){
      HashMap<Integer, String> materialMap = PowerPreference.getFileByName(powerPrefFile).getMap(powerPrefMat, structure);
      if(!materialMap.isEmpty()){
           populateSpinner(materialMap);
      }
}