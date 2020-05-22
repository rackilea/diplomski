// Setup list
List<String> list = new ArrayList<>();
list.add("TP");
list.add("PROVIDES");
list.add("QUALITY");
list.add("TUTORIALS");
list.add("Stop");
list.add("StopP");

// Sort list
Collections.sort(list);

// Iterate all elements and use binary search
Iterator<String> iter = list.iterator();
while (iter.hasNext()) {
    String element = iter.next();
    System.out.println("element : " + element
        + " >> Search result : "
        + Collections.binarySearch(list, element));
}