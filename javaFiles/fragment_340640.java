class Variable {

    private String name;
    private int[] domain;
};
final Set<Variable> variables = new TreeSet<Variable>( new Comparator<Variable>() {

    public int compare(Variable o1, Variable o2) {
        //Do comparison here
        //return -1 if o1 is less than o2
        //1 if o1 is greater than o2
        //0 if they are the same
    }
});