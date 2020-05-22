List<Material> materialArray = data.getMaterial();
HashMap<Integer, String> materialMap = new HashMap<Integer, String>();
for(Material material : materialArray){
     materialMap.put(Integer.parseInt(material.getId()), material.getMaterialName());
}
if(PowerPreference.getFileByName(powerPrefFile).contains(powerPrefMat)){
     PowerPreference.getFileByName(powerPrefFile).remove(powerPrefMat);
}
PowerPreference.getFileByName(powerPrefFile).putMap(powerPrefMat, materialMap);