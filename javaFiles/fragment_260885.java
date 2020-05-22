// please, don't use raw types!
Iterator<? extends MyObject> it = topContainer.subList.iterator();
while (it.hasNext()) {
   MyObject curObj = it.next();
   if ( !curObj.getLabel().contains("/") ) {
       String newLabel = curObj.getLabel() + "/";
       curObj.setLabel(newLabel);
   }
}