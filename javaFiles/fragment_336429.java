Collections.sort(list1, new Comparator<student>() {
    public int compare(student a, student b) {
        if(a.tot_marks < b.tot_marks)
           return -1;
        else if (a.tot_marks > b.tot_marks)
            return 1;
        else
            return a.username.compareTo(b.username);
    }
});