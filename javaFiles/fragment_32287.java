Comparator<Student> comparator = new Comparator<Student>() {
    @Override
    public int compare(Student s1, Student s2) {
        return (int) (s1.getScore() - s2.getScore());
    }
};

Queue<Student> queue = new PriorityQueue<Student>(11, comparator);

// put some students into queue here ...

Student firstInQueue = queue.poll();