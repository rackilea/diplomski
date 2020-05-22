class User 
{
   List<Workout> _workouts;
}

class Workout
{
    Date _startdate;
    Date _enddate;
    Map<Exercise,List<Set>> _exercises;
}

class Exercise
{
    String _name;
}        

abstract class Set
{
    abstract int getTotal();
}

class WeightSet extends Set
{
    int _weight;
    int _reps;

    @override
    public String toString() {return _weight + "X" + _reps;}
}

class CardioSet extends Set
{
    int _durationInSeconds; 
    int _distance;
}