final Map<String, List<Test>> gradesMap = new HashMap<>();

final Test math = new Test("Finding determinant of Matrix 4x4", 6.5);
final Test geography = new Test("Capitals around the world", 8.6);

final List<Test> testList = new ArrayList<>();
testList.add(math);
testList.add(geography);

gradesMap.put("Josh", testList);


private class Test {

    public final String subject;
    public final double grade;

    public Test(final String subject, final double grade) {
        this.subject = subject;
        this.grade = grade;
    }
}