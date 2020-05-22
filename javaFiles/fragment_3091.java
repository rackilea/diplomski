public void addStudentGrade(Object stu, float grade) {
    // Search for insertion point (i.e. between prevIdx and nextIdx)
    int prevIdx = NUL;
    int nextIdx = list;
    while (nextIdx != NUL && nodes[nextIdx].grade >= grade) {
        prevIdx = nextIdx;
        nextIdx = nodes[nextIdx].next;
    }

    // Initialize and insert new node
    int newIdx = getNode();
    nodes[newIdx].student = stu;
    nodes[newIdx].grade = grade;
    nodes[newIdx].next = nextIdx;
    if (prevIdx == NUL)
        list = newIdx;
    else
        nodes[prevIdx].next = newIdx;
}