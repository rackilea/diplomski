catch (ExecutionException e) {
    Throwable ee = e.getCause ();

    if (ee instanceof InvalidInputException)
    {
        //error handling 1
    } else if (ee instanceof MiscalculationException e)
    {
        //error handling 2
    }
    else throw e; // Not ee here
}