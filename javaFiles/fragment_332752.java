private static final String REGEX =
    "^((Idle|LOCKED) *)?\\(?([a-z]+)\\)?(-OK)?$";

... your code ...

System.out.println(locked.replaceAll(REGEX, "$3"));
System.out.println(idle.replaceAll(REGEX, "$3"));
System.out.println(OK.replaceAll(REGEX, "$3"));