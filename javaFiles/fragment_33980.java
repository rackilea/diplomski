public static void main(String[] args) {
    StudentsRecord record=new StudentsRecord(1, "Pramod", "UNA");
    StudentsRecord record2=new StudentsRecord(2, "Pankaj","Lucknow");
    StudentsRecord record3=new StudentsRecord(3, "Santosh","Chennai");


    Set<StudentsRecord> set=new LinkedHashSet<StudentsRecord>();
    set.add(record);
    set.add(record2);
    set.add(record3);


    Iterator<StudentsRecord> iterator=set.iterator();
    while(iterator.hasNext())
    {
        StudentsRecord result=(StudentsRecord)iterator.next();
        System.out.println(result.getId()+","+result.getName()+","+result.getAddress());
    }

}