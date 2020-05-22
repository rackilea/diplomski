final Class[] argTypes = new Class[args.length - 1];
final String[] cmdArgs = new String[args.length - 1];
for (int i = 0; i < argTypes.length; i++) {
  argTypes[i] = String.class;
  cmdArgs[i] = args[i+1];
}
final Command c = (Command) Class.forName(MY_PACKAGE + args[0]).getConstructor(argTypes)
   .newInstance(cmdArgs);