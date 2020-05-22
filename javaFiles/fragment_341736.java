interface Individual<T,I extends Individual<T, I>>  {
    public T getVariableValue(int index) ;
    public void setVariableValue(int index, T value) ;

    public int getNumberOfVariables() ;
    public int getNumberOfObjectives() ;

    public I copy() ;
}