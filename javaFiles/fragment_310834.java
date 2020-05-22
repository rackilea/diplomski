Collection<Student> temp = new LinkedList<>();
while (!pq.isEmpty()) {
    Student s = pq.poll();
    System.out.println(s.getName() + " " + s.getCgpa() + " " + s.getId());
    temp.add(s);
}
pq.addAll(temp);