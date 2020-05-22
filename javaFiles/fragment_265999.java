Iterator<String[]> iterator = myEntries.iterator();
while(itr.hasNext())
    for(String temp : itr.next()) 
        // Don't worry, itr.next() will be created only one time
        // for an each iteration (while)
        System.out.println(temp);