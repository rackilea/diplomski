class Project implements Comparable<Project> {

    @Override
    public int compareTo(Project o) {
        if (this.getEndTime() > o.getEndTime())
        return 1;
    else
        return 0;
    }
}