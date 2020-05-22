class Condition1 implements Condition{

    public boolean isSatisfied(Context context){
       ...
    }

    public void execute(Context context){
        doSomeStuff();
    }
}


class Condition2 implements Condition{

    public boolean isSatisfied(Context context){
       ...
    }

    public void execute(Context context){
       //do nothing
    }
}


class Condition3 implements Condition{

    public boolean isSatisfied(Context context){
       return !context.notCondition3();
    }

    public void execute(Context context){
        doRestOfStuff();
    }
}