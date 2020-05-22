Map<String,Boolean> diffMap = Main.scanForDifferences(oldMap, newMap);

Iterator<Map.Entry<String, Boolean>> it = diffMap.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry<String,Boolean> entry = (Map.Entry<String,Boolean>)it.next();
    System.out.println("Field [" + entry.getKey() +"] is " +
                        (entry.getValue()?"NOT ":"") + "different" );
}