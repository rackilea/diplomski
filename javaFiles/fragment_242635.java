@Component
public class ApplicationFrame extends javax.swing.JFrame
{
    private final PersonRepository personRepository;

    /**
    * Creates new form ApplicationFrame
    */
    public ApplicationFrame(final PersonRepository pr)
    {
        personRepository = pr;

        initComponents();
        System.out.println("personRepository = " + personRepository);
    }
}