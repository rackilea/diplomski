class Scratch {
    public static void main(String[] args) {
        Student student = new Student();
        Teacher teacher = new Teacher();

         setNameAndSurname(teacher);
    }

    private static void setNameAndSurname(final Person person) {
        person.setName("artemas");
        person.setSurname("prime");
        person.setAge("20");
    }
}