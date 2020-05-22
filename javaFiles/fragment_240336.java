public String concat(String a, String b) {
    final StringBuilder builder = new StringBuilder();
    new Thread(new Runnable() {
        @Override
        public void run() {
            builder.append("haha!");
        }
    }).start();
    builder.append(a);
    builder.append(b);
    return builder.toString();
}