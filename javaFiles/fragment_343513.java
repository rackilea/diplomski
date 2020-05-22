public static void setSomeThing(boolean value, Target ... targets){
    if(targets == null)
        return;

    for(Target target : targets){
        target.setSomeThing(value);
    }
}