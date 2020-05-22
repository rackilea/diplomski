// Add sorting for the Name column
   ListHandler<Asset> urlSortHandler = new ListHandler<Asset>(dataProvider.getList());
   urlSortHandler.setComparator(urlColumn, new Comparator<Asset>() {
     public int compare(Asset o1, Asset o2) {
        ....
     }
   });
   table.addColumnSortHandler(urlSortHandler);

   // Add sorting for the Size column
   ListHandler<Asset> sizeSortHandler = new ListHandler<Asset>(dataProvider.getList());
   sizeSortHandler.setComparator(sizeColumn, new Comparator<Asset>() {
     public int compare(Asset o1, Asset o2) {
        ....
     }
   });
   table.addColumnSortHandler(sizeSortHandler);

   // Add sorting for the Type column
   ListHandler<Asset> mimeSortHandler = new ListHandler<Asset>(dataProvider.getList());
   mimeSortHandler.setComparator(mimeColumn, new Comparator<Asset>() {
      public int compare(Asset o1, Asset o2) {
         ...
      }
   });
   table.addColumnSortHandler(mimeSortHandler);