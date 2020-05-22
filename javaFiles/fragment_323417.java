public class ActionFactory{
    public Action createAction(String type){
        if (type.equals("MOVE"))
            return new ActionMove();
        if (type.equals("KILL"))
            return new ActionKill();
        ... // so on for the other types

        return null; //if the type doesn't have any of the expected values
    }
    ...
}