@Autowired
public School(Environment env) {
    this.schoolName = env.getProperty("mi.name", "MT");
    this.schoolGrade = env.getProperty("mi.grade", Integer.class, 10);
    this.totalStudents = env.getProperty("mi.total", Integer.class, 1000);
}