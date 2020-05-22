String[] errors = {"5 Error(s)", "50 Error(s)", "0 Error(s)"};
//                           | starts with digit > 0
//                           |    | optionally ends with 0 or more digits
//                           |    |    | rest of the pattern
Pattern p = Pattern.compile("[1-9]\\d* Error\\(s\\)");
for (String s: errors) {
    System.out.println(s.matches(p.pattern()));
}