for(String element : arrayExplodedCommands)
{
    listCommands.add(element);
}
ProcessBuilder ps = new ProcessBuilder(listCommands);

ps.redirectErrorStream(true);
Process p = ps.start();
// That's it.