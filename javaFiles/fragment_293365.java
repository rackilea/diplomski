Map<String, String> map = (Map<String, String>) av.getItemAtPosition(index);
Iterator<String> myVeryOwnIterator = map.keySet().iterator();
while (myVeryOwnIterator.hasNext()) {
    String key = (String) myVeryOwnIterator.next();
    String value = (String) map.get(key);
    getNumber.setText(value);                                    
}