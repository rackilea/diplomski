//temp contains max length value

it = map.entrySet().iterator();
System.out.println("Max length : " + temp);
while(it.hasNext()) {
    Map.Entry str=(Map.Entry)it.next();

    if (str.getValue().equals(temp)) {
        System.out.println("Word : "  + str.getKey());
    }
}