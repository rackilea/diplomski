class SimplePerson{

    ComplexPerson _person;

    public void WalkForward (int steps){

        for (int i = 0; i < steps; i ++){
            _person.LeftFoot ();
            _person.MoveFoot ();
            _person.PlaceFoot ();
        }
    }
    // More methods
}