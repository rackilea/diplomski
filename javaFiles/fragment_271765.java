public enum UserType {
    Student("Under Graduate Student", 1, 20),
    PostStudent("PostGraduate Student", 2, 30),
    AdminStaff("Administrative Staff", 3, 30),
    Librarian("Librarian", 4, 40),
    AcademicStaff("Academic Staff", 5, 40),
    Admin("System Administrator", 6, 30);

    private String name;
    private int id;
    private int numberOfAllowedBooksToBorrow;

    private UserType(final String n, int i, int nb) {
      this.name = n;
      this.id = i;
      this.numberOfAllowedBooksToBorrow = nb;
    }
    public String getName(){ return name; }
    public int getId(){ return id; }
    public int getNumberOfAllowedBooksToBorrow(){ return numberOfAllowedBooksToBorrow; }
    public String toString(){ return name; }
}