StringBuilder builder = new StringBuilder();

try {
    builder.append("John");
    builder.append("Ibrahim");
} finally {
    System.out.println("In finaly");  // builder.append("-DarElBeida");
    builder = null;
}

return builder;