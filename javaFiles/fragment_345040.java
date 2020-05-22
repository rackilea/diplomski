// Compute the changed items and set them in the original list
ListChangeset listDiff = new ListChangeset(updatedList, originalList);

originalList.getItems().removeAll(listDiff.computeItemsToDelete());
originalList.getItems().addAll(listDiff.computeItemsToAdd());

return listDAO.saveAndFlush(originalList);