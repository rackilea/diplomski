public static void main(String [] args) throws FileNotFoundException
{        
    Scanner data = new Scanner(new File("exams.txt"));
    Exam[] readObjects = readAllExams(data);

    System.out.println("1) Initially the list of exams of students is: ");
    System.out.println();
    for(int i = 0; i < readObjects.length; i++)
    {
        System.out.println(readObjects[i]);
    }

    Exam[] collateObjects = collateExams(readObjects);

    System.out.println("Sorted list: ");
    for (int i = 0; i < collateObjects.length; i++)
    {
        System.out.println(collateObjects[i]);
    }
}

public static Exam[] readAllExams(Scanner s) throws ArrayIndexOutOfBoundsException
{

    int index = 0;
    Exam[] object = new Exam[s.nextInt()];

    while(s.hasNext())
    {
        object[index] = readExam(s);
        index++;
    }

    return object;
}

public static Exam readExam(Scanner s)
{
    String firstName = "";
    String lastName = "";
    int ID = 0;
    String examType = "";
    char examTypeCasted = 0;
    int score = 0;

    //Returns firtsName and lastName 
    firstName = s.next();
    lastName = s.next();

    //Returns ID number
    if(s.hasNextInt())
    {
        ID = s.nextInt();
    }
    //Returns examType which is 'M' or 'F'
    examType = s.next();
    examTypeCasted = examType.charAt(0);

    if(s.hasNextInt())
    {
        score = s.nextInt();
    }

    return new Exam(firstName, lastName, ID, examTypeCasted, score);
}

public static Exam[] collateExams(Exam[] exams)
{
    Exam [] r = new Exam[exams.length];
    System.arraycopy(exams, 0, r, 0, exams.length); 

    int [] position = new int[exams.length];


    for(int i = 0;i < position.length;i++)
        position[i]=-1;

    for(int i = 0; i < exams.length; i++)
    {
       int nextPos = determineNextPosition(position, exams[i]);
       r[nextPos] = new Exam(exams[i].getFirstName(), exams[i].getLastName(), exams[i].getID(), exams[i].getExamType(), exams[i].getScore());
    }

    return r;
}

private static int determineNextPosition(int[] posArray, Exam exam)
{
    int position = -1;
    int id = exam.getID();

    // see if there is a spot for the ID already
    for (int i = 0; i < posArray.length; i++)
    {
        if (posArray[i] == id)
        {
            position = i;
            break;
        }
    }

    if (position < 0)
    {
        // if a spot wasnt found, make one
        for (int i = 0; i < posArray.length; i+=2)
        {
            if (posArray[i] == -1)
            {
                posArray[i] = id;
                posArray[i+1] = id;
                position = i;
                break;
            }
        }
    }

    if (position < 0) throw new RuntimeException("Something went really wrong");

    if (exam.getExamType() == 'm')
    {
        return position;
    }
    else
    {
        return position + 1;
    }               
}