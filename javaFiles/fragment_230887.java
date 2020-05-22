String w = "York";
String k = "Oxford";
String t = "Sam";

String s1, s2, s3;
// insert first 2 values in correct order
if (w.compareTo(k) <= 0) {
    s1 = w;
    s2 = k;
} else {
    s1 = k;
    s2 = w;
}
// insert 3rd value in correct place
if (s2.compareTo(t) <= 0) {
    s3 = t;
} else {
    s3 = s2;
    if (s1.compareTo(t) <= 0) {
        s2 = t;
    } else {
        s2 = s1;
        s1 = t;
    }
}

System.out.println(s1);
System.out.println(s2);
System.out.println(s3);