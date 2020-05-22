for(MyObj item : list) {
     String name = item.getName();
     if(haveSeen(name) {
         MyObj destinationItem = findDestinationItem(name);
         destinationItem.setValue(destinationItem.getValue() + item.getValue());
     } else {
         addDestinationItem(copy(item));
     }
 }
 return listDestinationItems();