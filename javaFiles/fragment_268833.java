Prepod prepod = null;
    Student  student = null;
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    prepod = (Prepod) session.load(Prepod.class, 1l);
    student = (Student) session.load(Student.class, 1l);
    session.getTransaction().commit();
    session.flush();
    session.close();
            List<Student> students = new ArrayList<Student>();
    students.add(student);

    List<Prepod> prepods = new ArrayList<Prepod>();
    prepods.add(prepod);

    prepod.getStudents().addAll(students);//exception here
    student.getPrepods().addAll(prepods);