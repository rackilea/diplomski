public class Input {
    private int[] std_id;// initiating 20 size 
    private String[] name;
    private int[] age;
    private String[] email;

    Scanner in = new Scanner(System.in);

    private final List<Student> Students = new ArrayList<Student>();

    public Input()
    {
        initInput();
    }

    public void initInput()
    {
         int rec;
         System.out.println("How  many records do u want to enter:");
         rec = in.nextInt();

        std_id = new int[rec];
        name = new String[rec];
        age = new int[rec];
        email = new String[rec];

        for(int i=0 ; i < rec; i++)
        {
            std_id[i] = in.nextInt();
            name[i] = in.next();
            age[i] = in.nextInt();
            email[i] = in.next();
        }

        for(int i=0; i < rec ; i++)
        {
            Students.add(new Student(std_id[i],name[i], age[i], email[i]));
        }
    }   
}