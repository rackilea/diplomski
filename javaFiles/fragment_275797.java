int positionToDelete = 2;
Model modelToDelete = modelList.get(positionToDelete - 1);
modelList.remove(modelToDelete);
for(int i = positionToDelete - 1; i < modelList.size(); i++){
  Model modelToChange = modelList.get(i);
  modelToChange.setPosition(modelToChange.getPosition() - 1);
}