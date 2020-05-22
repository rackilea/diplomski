Observable.zip(observableList, new FuncN(){
    public ReturnType call(java.lang.Object... args){
        ReturnType result; //to be made
        //preparatory code for using the args
        for (Object obj : args){
            ReturnType retObj = (ReturnType)obj;
            //code to use the arg once at a time to combine N of them into one.
        }
        return result;
    }
});