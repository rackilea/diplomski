public class Project5 {

    static class Student {

        private String name;
        private final List<Integer> scores;
        private int total;

        public Student() {
            scores = new ArrayList<>();
            total = 0;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void addScore(int score) {
            scores.add(score);
            total += score;
        }

        public String getName() {
            return name;
        }

        public List<Integer> getScores() {
            return scores;
        }

        public int getTotal() {
            return total;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(name).append('\t').append(total);
            for (Integer score : scores) {
                sb.append('\t').append(score);
            }
            return sb.toString();
        }

    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String filename = in.nextLine();
        in.close();

        File filetest = new File(filename);
        Scanner imp = new Scanner(filetest);
        int total = Integer.parseInt(imp.nextLine());

        System.out.println("Name\tTotal\tScore 1\tScore 2\tScore 3");

        for (int i = 0; i < total && imp.hasNextLine(); i++) {
            Student student = new Student();
            student.setName(imp.nextLine());
            while (imp.hasNextInt()) {
                student.addScore(imp.nextInt());
            }
            if (imp.hasNext()) {
                imp.nextLine();
            }
            System.out.println(student);
        }
        imp.close();
    }

}