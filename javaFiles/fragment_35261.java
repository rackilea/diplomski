List<WidgetItem> selectedItems = 
    widgetItems.stream()
               .collect(Collectors.groupingBy(
                  WidgetItem::getAvailableStock,
                  TreeMap::new,
                  Collectors.toList()
               ))
               .firstEntry()
               .getValue();