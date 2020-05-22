public static synchronized int statefulMethod(){
    //this should be protected
}

public static int nonStatefulMethod(){
    //Just returns a static value such as 5
    //so this is thread safe as it does not have any state
}

public static synchronized int otherStatefulMethod(){
    //this should also be thread safe
}