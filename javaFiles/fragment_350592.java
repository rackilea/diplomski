/*
 * The TutorRole can be set at runtime
 */
public class Student {

    private String facultyId;

    private TutorRole tutorRole = null;

    public boolean isTutor() {
        return !(tutorRole == null);
    }

    public void doTutorStuff() {
        if(isTutor()) {
            tutorRole.doTutorStuff();
        }
        else {
            throw new NotTutorException();
        }
    }

    public void setTutorRole(TutorRole tutorRole) {
        this.tutorRole = tutorRole;
    }
}

/*
 * Ideally this class should implement a generic interface, but I'll keep this simple
 */
public class TutorRole {

    public void doTutorStuff() {
        // implementation here
    }
}

/*
 * Now let's use our classes...
 */
Student st = new Student(); // not a tutor
st.setTutorRole(new TutorRole()); // now a tutor
if(st.isTutor()) {
    st.doTutorStuff();
}
st.setTutorRole(null); // not a tutor anymore