Object value = subjectsResults.get(1); 
if (value instanceof Integer) {
  numberOfA = (Integer) value;
} else if (value instanceof Float) {
  numberOfA = ((Float) value).intValue();
} else {
  handle this unusual case
}