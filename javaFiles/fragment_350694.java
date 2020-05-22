ArrayList<Model> localModels = new ArrayList<>(mModels.size());

for(Model model: mModels){
 Models tempModel = new Model();
 tempModel.setId(model.getId());
 tempModel.setName(model.getName());
 ....
 ....
 localModels.add(tempModel);
}

return localModels();