boolean match = false;
for (Object o : objectList) {
    if (o.someValue()).equals(o2.someValue())) {
        match true;
        break;       // no point in iterating further
    }
}

if (!match) {
    System.out.println("No match was found in the list.");
}