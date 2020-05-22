Method[] methods = getAllDeclaredMethods(this.getClass());

for (int i = 0; i < methods.length; i++) {
    Method m = methods[i];

    if (m.getName().equals("doGet")) {
        ALLOW_GET = true;
        ALLOW_HEAD = true;
    }
    if (m.getName().equals("doPost"))
        ALLOW_POST = true;
    if (m.getName().equals("doPut"))
        ALLOW_PUT = true;
    if (m.getName().equals("doDelete"))
        ALLOW_DELETE = true;
}