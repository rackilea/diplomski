final String status;
String temp;

try {
    method1();
    method2();
    method3();
    temp = "OK";
} catch (Exception e) {
    temp = "BAD";
}

status = temp;