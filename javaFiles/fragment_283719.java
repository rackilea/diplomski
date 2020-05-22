char[][] createWorld(String file)
{
    try {
        List<String> lines = Files.readAllLines(Paths.get(file),
            Charset.forName("US-ASCII"));
        char[][] world = new char[lines.size()][];
        int i = 0;
        for(String ln: lines)
            world[i++] = ln.toCharArray();
        return world;
    } catch (IOException ex) {
        Logger.getGlobal().log(Level.SEVERE, null, ex);
    }
    return null;
}