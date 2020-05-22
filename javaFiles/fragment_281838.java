startTime = System.nanoTime();
rs = ...;
while rs.next() {
    integer id = rs.getInt(1));
    String middleInitial = rs.getString(3);
    if (middleInitial == null) {
        String name = rs.getString(2) + " " + rs.getString(4);
    } else {
        String name = rs.getString(2) + " " + middleInitial + " " + rs.getString(4);
    }
    String phone = rs.getString(5).length() == 12 ? rs.getString(5) : rs.getString(6);
    DirectoryBoxesPanel.add(new DirectoryBoxes(name, id, phone, selection));    
}
endTime = System.nanoTime();
duration = (endTime - startTime);
System.out.println("For LOOP: " + duration/1000000L);