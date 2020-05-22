Iterator<String[]> iter = dataVector.iterator();

while( iter.hasNext()) {
    String[] array = iter.next();
    for(int i=0; i < array.length; i++)
    {
       System.out.println(i + ": " + array[i]);
    }
}