public class Student extends Person {
    private List<ClassGrade> classes = new ArrayList<ClassGrade>();

    public List<ClassGrade> getClassGrades() {
        return new ArrayList<ClassGrade>(classes);
    }

    public void addClass(String clazz, int grade) {
        classes.add(new ClassGrade(clazz, grade));
    }

    public static class ClassGrade {
        String clazz;
        int grade;

        public ClassGrade(String clazz, int grade) {
            this.clazz = clazz;
            this.grade = grade;
        }

        public String getClazz() {
            return clazz;
        }

        public int getGrade() {
            return grade;
        }
    }
}