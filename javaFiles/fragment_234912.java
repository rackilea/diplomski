public static int findLongestFirstName(ArrayList<Student> studentList) 
{
    int longest = 0;
    for (Student student : studentList) {
        longest = Math.max(student.getFirstName().length(), longest);
    }
    return longest;
}