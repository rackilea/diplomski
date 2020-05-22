classRooms = Collections.sort(classRooms , new Comparator<Classroom>() {
    public int compare(Classroom o1, Classroom o2)
    {
        return o1.getSize() < o2.getSize();
    }
});

studentGroups = Collections.sort(studentGroups, new Comparator<StudentGroup>() {
    public int compare(StudentGroup o1, StudentGroup o2)
    {
        return o1.getSize() < o2.getSize();
    }
});

int classRoomIndex = 0;
for(StudentGroup group : groups){
    while(classRoomIndex < classRooms.size()){
        Classroom classRoom = classRooms.get(classRoomIndex++);
        if(classRoom.getSize() >= group.getSize())
        {
            // place group to classroom
            break;
        }
    }
    if(classRoomIndex == classRooms.size()){
        // no classrooms for groups
        notInClass.addAll(groups.subList(groups.indexOf(group), groups.size()));
        break;
    }
    notInClass.add(group);
}