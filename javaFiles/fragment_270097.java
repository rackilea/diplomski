public static Comparator<Student> getCompByName()
{

    Comparator comp = new Comparator<Student>(){

        @Override
        public int compare(Student s1, Student s2)
        {
            s1.name.compareTo(s2.name)
        }

    };

    return comp;
}