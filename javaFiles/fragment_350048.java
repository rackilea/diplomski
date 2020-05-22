@FunctionalInterface
interface SomethingThatThrows<T> {
    T execute() throws XXXX, YYYY, InterruptedException,ExecutionException;
}

private static <T> T handledFuntion(SomethingThatThrows<T> function) throws XXXX, YYYY {
    try {
        return function.execute();
    } catch (InterruptedException | ExecutionException e) {
        Throwable throwable = e.getCause();
        if (throwable instanceof XXXX) {
            throw (XXXX) throwable;
        } else if (e instanceof YYYY) {
            throw (YYYY) throwable;
        } else if (throwable != null) {
            throw new RuntimeException(throwable);
        } else {
            throw new RuntimeException(e);
        }
    }
}

// Use lambda literal - may be better when arguments are involved
public A createA(String arg1) throws XXXX, YYYY {
   return handledFuntion(() -> {
         // write code just like you'd write it in try{} body - 
         // all arguments to createA() are available
         return new A(arg1);
     });
}

// use a method handle, works best when there are no arguments
public B createB() throws XXXX, YYYY {
       return handledFuntion(this::somethingThatMakesB);
}


private B somethingOtherThatMakesB() throws XXXX, YYYY, InterruptedException,ExecutionException {
    // Some logic that creates and returns B
}