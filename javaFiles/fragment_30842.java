@Test 
public void testCountPerson() {    
    School mSchool = School.getInstance();
    School spySchool = Mockito.spy(mSchool); // a spy is created here, Mockito is listening in.
    spySchool.countPerson(true); // real method is invoked
    verify(spySchool).countIncludeTeacher(); // our spy identified that countIncludeTeacher was called

    spySchool.countPerson(false); // real method is invoked
    verify(spySchool, times(0)).countIncludeTeacher(); // our spy still identified that countIncludeTeacher was called, before it was called before
}