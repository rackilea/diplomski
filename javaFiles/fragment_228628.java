Collections.sort(StudentList, new Comparator<Student>() {
    @Override
    public int compare(Student obj1, Student obj2) {
        if(obj1.Rank==0) return (obj2.Rank==0) ? 0 : 1;
        if(obj2.Rank==0) return -1;
        return Integer.compare(obj1.Rank,obj2.Rank);
    }
});