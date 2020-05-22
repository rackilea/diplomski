public int compareTo(User object) {
if (this.getPriorityScore() < object.getPriorityScore())
    return -1;
if (this.getPriorityScore() == object.getPriorityScore())
    return 0;
return 1;
}