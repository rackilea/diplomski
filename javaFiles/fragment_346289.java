public static void main(String[] args) throws IOException
{
    ArrayList<String> argsList = new ArrayList<String>(Arrays.asList(args));
    argsList.add("--disableInternalCommands");
    String[] argsArray = new String[argsList.size()];
    argsArray = argsList.toArray(argsArray);
    Bootstrap.main(argsArray);
}