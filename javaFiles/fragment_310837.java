public class StComp implements Comparator<Student> {

    @Override
    public int compare(Student st1, Student st2) {
        if (st1.getCgpa() == st2.getCgpa()) {
            if (st1.getName().equals(st2.getName())) {
                return st1.getId() - st2.getId();
            } else {
                return st1.getName().compareTo(st2.getName());
            }
        } else {
            return (st1.getCgpa() < st2.getCgpa()) ? 1 : -1;
        }
    }
}