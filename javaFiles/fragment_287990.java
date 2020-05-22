int badArgs = 0;
for(int i = 0; i < args.length; i++) {

  try {
    int value = Integer.parseInt(args[i]);
    // Do your main logic with value here
  } catch (NumberFormatException e) {
    ignored[badArgs++] = args[i];
  }