private MainClass mainClass;

@Before
public void setup() {
    IClass instance1 = mock(IClass.class); 
    IClass instance2 = mock(IClass.class);

    mainClass = new MainClass(instance1, instance2);
}