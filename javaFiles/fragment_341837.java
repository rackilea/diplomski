String key="default";
Iterator myVeryOwnIterator = CHILD_NAME_DOB.keySet().iterator();
while(myVeryOwnIterator.hasNext()) {
     key=(String)myVeryOwnIterator.next();
     //String value=(String)meMap.get(key);
     }
Toast.makeText(viewEnterChildExp.getContext(), "Key: "+key , Toast.LENGTH_LONG).show();