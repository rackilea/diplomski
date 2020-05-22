public void readFile() throws IOException {
    try (Scanner s = new Scanner(new FileReader(new ClassPathResource("Students.txt").getFile()))) {
        while (s.hasNextLine()) {
            String name = s.nextLine();
            int age = Integer.parseInt(s.nextLine());
            double gpa = Double.parseDouble(s.nextLine());
            Student studentOne = new Student(name, age, gpa);
            students.add(studentOne);
        }
    }
}