public static String[] arr(String... args) {
    return args;
}

sqlExecute("exec blah ?, ?", 
    arr("account.name", "foo"), 
    arr("account.region", "bar"));