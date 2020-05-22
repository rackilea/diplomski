MyEntry[] entries = new MyEntry[5];
 entries[0]= new MyEntry(1.1,5);
 entries[1]= new MyEntry(1.1,4);
 entries[2]= new MyEntry(2.1,5);
 entries[3]= new MyEntry(0.1,3);
 entries[4]= new MyEntry(3.1,1);

 IndexedArrayComparator comp = new IndexedArrayComparator(entries);
 Integer[] index = comp.createIndexes();
 Arrays.sort(index,comp);
 for(int i =0;i<index.length;i++){
     MyEntry e = entries[index[i]];
     System.out.println(String.format("%2d:r= %3.1f, d= %3.1f" ,index[i],e.rank,e.dist));
 }