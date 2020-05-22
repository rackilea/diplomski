while (true) {
    try {
        // Do a lot of things that can throw
        if(something_bad_happens) throw new Error();

        /*
         * This sleep will only be reached
         * if we don't throw
         */
        Thread.sleep(30000);
    } catch (errors) {
        // Deal with errors
    }
}