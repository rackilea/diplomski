public class Registration {
    private int gradeLevel;

    public Registration(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }


    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.gradeLevel;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Registration other = (Registration) obj;
        if (this.gradeLevel != other.gradeLevel) {
            return false;
        }
        return true;
    }


}