private void myMethod() {
    ...
    flag = preconditionflag.equals("skip") ?
           showMessageAndReturn("Skipping this testcase due to earlier testcase failed", "skip") :
           "pass";
    ...
}

private String showMessageAndReturn(String message, String retVal) {
    System.out.println(message);
    return retVal;
}