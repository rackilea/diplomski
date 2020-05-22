private State USA = new State("United States of America");
    private State CAN = new State("Canada");
    private State MEX = new State("Mexico");
    private State[] stateArray = new State[3];
    int index = 0;
    public static void main()
    {
    }


    public void addState(State state) //I need a way to add the Private objects called State into an array here. The command must take User Interface
    {
       if(index < stateArray.length)
           stateArray[index++] = state;
    }