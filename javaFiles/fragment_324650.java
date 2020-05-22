@Test
public void subTest () {
    FakeApplication app = Helpers.fakeApplication(Helpers.inMemoryDatabase());
    Helpers.start(app);

    Project p1 = new Project();
    p1.id=1L;

    SubProject s1 = new SubProject();
    SubProject s2 = new SubProject();
    s1.id=1L;
    s2.id=2L;

    p1.subprojects.add(s1);
    p1.subprojects.add(s2);
    s1.project = p1;
    s2.project = p1;

    MiniProject m1 = new MiniProject();
    MiniProject m2 = new MiniProject();
    MiniProject m3 = new MiniProject();
    MiniProject m4 = new MiniProject();

    m1.id=1L;
    m2.id=2L;
    m3.id=3L;
    m4.id=4L;

    s1.miniprojects.add(m1);
    s1.miniprojects.add(m2);
    s2.miniprojects.add(m3);
    s2.miniprojects.add(m4);

    m1.subproject =s1;
    m2.subproject =s1;
    m3.subproject =s2;
    m4.subproject =s2;

    Ebean.save(p1);
    Ebean.save(s1);
    Ebean.save(s2); 
    Ebean.save(m1);
    Ebean.save(m2);
    Ebean.save(m3);
    Ebean.save(m4);

    // retrieve all the subprojects of a list of Projects
    List<Long> projectIds = new ArrayList<Long>();
    projectIds.add(1L);     
    List<SubProject> subList = Ebean.createQuery(SubProject.class).where(Expr.in("project.id", projectIds)).findList();

    // retrieve all the miniprojects of a Project 
    Long projectId = 1L;
    List<MiniProject> miniList = Ebean.createQuery(MiniProject.class).where(Expr.eq("subproject.project.id", projectId)).findList();

    // given a list of sub projects , how to retrieve all the miniprojects
    List<Long> subprojectIds = new ArrayList<Long>();
    subprojectIds.add(1L);      
    List<MiniProject> miniSubList = Ebean.createQuery(MiniProject.class).where(Expr.in("subproject.id", subprojectIds)).findList();


    for(SubProject sub: subList) {
        System.out.println("subproject: "+sub.id);
    }
    System.out.println("-----------");
    for(MiniProject mini: miniList) {
        System.out.println("miniproject: "+mini.id);
    }
    System.out.println("-----------");
    for(MiniProject mini: miniSubList) {
        System.out.println("miniproject: "+mini.id);
    }
}