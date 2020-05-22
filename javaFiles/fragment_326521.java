public abstract class Parent implements Comparable<Parent> { 

    abstract Integer getRegister();

    @Override
    public int compareTo(final Parent parent) {
        return this.getRegister().compareTo(parent.getRegister());
    }

}