public class StudentMain
{
    public static void main(String args[]) throws JAXBException
    {
        String input = "75414133,Mehdi,Javan,Math,16; 88887777,Shadi,Khani,English,18; 75414133,Mehdi,Javan,English,12; 88887777,Shadi,Khani,Physiques,16; 512345678,Mohamad,Sayadi,Chemistry,15; 88887777,Shadi,Khani,Math,15;";

        String[] studentRecords = input.split(";");

        List<Student> students = new ArrayList<Student>();

        for (String studentRecord : studentRecords)
        {
            String[] studentData = studentRecord.split(",");

            Student student = new Student(studentData[0], studentData[1], studentData[2]);

            if (students.contains(student))
            {
                student = students.get(students.indexOf(student));

                student.addScore(studentData[3], Integer.valueOf(studentData[4]));
            }
            else
            {
                student.addScore(studentData[3], Integer.valueOf(studentData[4]));                
                students.add(student);
            }
        }

        for (Student student : students)
        {
            student.printScoreCard();
        }
    }
}

class Student
{
    private String number;
    private String firstName;
    private String lastName;

    private Map<String, Integer> scores = new HashMap<String, Integer>();

    public Student(String number, String firstName, String lastName)
    {
        this.number = number.trim();
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
    }

    public void addScore(String subject, Integer score)
    {
        this.scores.put(subject, score);
    }

    public void printScoreCard()
    {
        System.out.println();
        System.out.println(number + "," + firstName + "," + lastName + ":");
        System.out.println("Average: " + getAverageScore());

        for (Entry<String, Integer> score : scores.entrySet())
        {
            System.out.println(score.getKey() + ": " + score.getValue());
        }

        System.out.println();
    }

    private double getAverageScore()
    {
        double average = 0.0;

        for (Entry<String, Integer> score : scores.entrySet())
        {
            average = average + score.getValue();
        }

        average = average / scores.size();
        return average;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || !(o instanceof Student))
        {
            return false;
        }

        Student compareTo = (Student) o;

        return number.equals(compareTo.number);
    }
}