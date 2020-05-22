public void desired() {
    //some logging X

    try {
        desired$instrumented();
    }
    finally {
        //some logging Y
    }
}