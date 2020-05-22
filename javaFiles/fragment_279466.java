public class Main {
private KieSession kieSession;
private KieScanner kieScanner;

public void build() throws Exception {
    KieServices kieServices = KieServices.Factory.get();
    KieFileSystem kfs = kieServices.newKieFileSystem();

    FileInputStream fis = new FileInputStream( "alla/alla.drl" );
    kfs.write( "src/main/resources/simple.drl",
                kieServices.getResources().newInputStreamResource( fis ) );

    KieBuilder kieBuilder = kieServices.newKieBuilder( kfs ).buildAll();

    Results results = kieBuilder.getResults();
    if( results.hasMessages( Message.Level.ERROR ) ){
        System.out.println( results.getMessages() );
        throw new IllegalStateException( "### errors ###" );
    }

    KieContainer kieContainer =
    kieServices.newKieContainer( kieServices.getRepository().getDefaultReleaseId() );

    KieBase kieBase = kieContainer.getKieBase();

    kieSession = kieBase.newKieSession();
}

public void exec(){
    Student albert = new Student();
    albert.setName( "Albert" );
    albert.setId( "001" );
    albert.getGrades().add( new Semester( "A", "A", "A" ) );
    albert.getGrades().add( new Semester( "A", "A", "A" ) );
    kieSession.insert( albert );

    Student bob = new Student();
    bob.setName( "Bob" );
    bob.setId( "002" );
    bob.getGrades().add( new Semester( "B", "B", "B" ) );
    kieSession.insert( bob );

    kieSession.fireAllRules();
}

public static void main( String[] args ) throws Exception {
Main m = new Main();
    m.build();
    m.exec();
}
}