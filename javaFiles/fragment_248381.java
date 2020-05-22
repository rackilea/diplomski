for (int i = 1; i < args.length; i++) {
    builder.append(args[i]);
    if (i < args.length - 1) {
      builder.append(" ");
    }
}