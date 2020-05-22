public class Main {

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new StComp());
        pq.add(new Student("John", 75, 50)); // Student name, grade average, id
        pq.add(new Student("Mark", 8, 24));
        pq.add(new Student("Shafaet", 7, 35));
        pq.poll();
        pq.poll();
        pq.add(new Student("Samiha", 85, 36));
        pq.poll();
        pq.add(new Student("Ashley", 9, 42));
        pq.add(new Student("Maria", 6, 46));
        pq.add(new Student("Anik", 95, 49));
        pq.add(new Student("Dan", 95, 50));
        pq.poll();

        // Not guaranteed to be in priorty order
        System.out.println("Using PriorityQueue's Iterator, may not be in the correct priority order.");
        for (Student s : pq) {
            System.out.println(s.getName() + " " + s.getCgpa() + " " + s.getId());
        }

        // Correct order, but removes from the Priority Queue
        System.out.println("\nIterating until empty using PriorityQueue.poll(), will be in the correct order.");
        while (!pq.isEmpty()) {
            Student s = pq.poll();
            System.out.println(s.getName() + " " + s.getCgpa() + " " + s.getId());
        }
    }

}