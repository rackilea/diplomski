for (AnyObject anyObject : anyObjectList) {
    if (anyObject != null) {
        System.out.println(anyObject.doSomething());
    } else {
        /* something went wrong -- report error, debugging info, etc. */
    }
}