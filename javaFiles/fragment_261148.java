ArrayList arrayListIdle = new ArrayList();


while(rs.next){

    state = new State();
    List<State> arrayState = new ArrayList<State>();

    state.updateStateArray(arrayState);//This function mods the elements of (arrayState);//This 
    state.setArrayStates(arrayState);//add a list of arrayState to the object state
    arrayListIdle.addAll(state);

}