public class ExampleIndividual<T> implements Individual<T, ExampleIndividual<T>> {

    public T getVariableValue(int index) { return null; }
    public void setVariableValue(int index, T value) {}

    public int getNumberOfVariables() { return 0; }
    public int getNumberOfObjectives() { return 0; }

    public ExampleIndividual<T> copy() { return new ExampleIndividual<T>(); }

}