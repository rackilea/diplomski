Map<String, Set<Double>> firstMap = new HashMap<String, Set<Double>>(  );
Map<String, Set<Double>> secondMap = new HashMap<String, Set<Double>>(  );
Set<Map.Entry<String, Set<Double>>> entries = firstMap.entrySet();
for ( Map.Entry<String, Set<Double>> entry : entries ) {
  Set<Double> secondMapValue = secondMap.get( entry.getKey() );
  if ( secondMapValue == null ) {
    secondMap.put( entry.getKey(), entry.getValue() );
  }
  else {
    secondMapValue.addAll( entry.getValue() );
  }
}