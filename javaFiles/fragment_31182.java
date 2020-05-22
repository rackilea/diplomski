private void filter(String keyW, Function<News, String> propertyExtractor) {
  neModel.setRowCount(0);

  //note that this could probably be replaced by for(News news : newList)
  //but in that case you'd either have to change createARow to not need the index or increment the index in the loop body
  for (int i = neList.size() - 1; i > -1; i--) {        
    if (propertyExtractor.apply(neList.get(i)).toLowerCase().contains(keyW.toLowerCase())) {
        Object[] aRow = createARow(i);
        neModel.addRow(aRow);
    }
  }
}

//Examples of how to use it, you don't have to keep those (delegating) methods
private void filterById(String keyW) { 
  filter( keyW, e -> String.valueOf(e.getId()));
}

private void filterByTitle(String keyW) { 
  filter( keyW, News::getTitle);
  //or: filter( keyW, e -> e.getTitle());
}