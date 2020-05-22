String foo = "This,that,other";
String[] split = foo.split(",");
StringBuilder sb = new StringBuilder();
for (int i = 0; i < split.length; i++) {
    sb.append(split[i]);
    if (i != split.length - 1) {
        sb.append(" ");
    }
}
String joined = sb.toString();