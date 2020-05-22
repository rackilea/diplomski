int i = 0, c = 0;

while ((line = reader.readLine()) != null ) {
    c = ++i;
    System.out.println("Count of records " + i +": " + c);
}
for (int j = 0; j < c; ++j) {    
    System.out.println("Element at index " + j +": " + columns[j]);
}