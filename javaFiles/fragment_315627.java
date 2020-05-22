public static String[] getCustomSortArray(String grade, String[] grades)
{
    int index = -1;
    for(int i = 0; i < grades.length; i++)
    {
        if(grades[i].equals(grade))
        {
            index = i;
            break;
        }
    }

    if(index == -1) return grades;

    String temp = new String[grades.length];
    temp[0] = grades[index];

    int counter = 1;
    for(int i = 0; i < grades.length; i++)
    {
        if(i != index) temp[counter++] = grades[i];
    }
    return temp;
}