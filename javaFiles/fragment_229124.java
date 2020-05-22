@Override
public int compareTo(Project project) {
    int i = this.projectDate.compareTo(project.projectDate);
    if(i != 0) return -i;  // reverse sort

    return this.projectName.compareTo(project.projectName);
}