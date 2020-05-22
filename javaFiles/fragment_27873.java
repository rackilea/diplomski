while (true) {
    try {
        // Do a lot of things that can throw
        if(something_bad_happens) throw new Error();
    } catch (errors) {
        // Deal with errors
    }

    // Always sleep between attempts no matter what
    Thread.sleep(30000);
}