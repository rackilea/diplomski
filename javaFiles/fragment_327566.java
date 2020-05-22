public boolean isGroup(String groupName, String playerName) {

    List<String> ironPlayers = getConfig().getStringList("groups.iron"); // Get list of names in iron group
    List<String> diamondPlayers = getConfig().getStringList("groups.diamond"); // Get list of names in diamond group

    boolean isIron = ironPlayers.contains(playerName); // Boolean value whether playerName is in iron group
    boolean isDiamond = diamondPlayers.contains(playerName); // Boolean value whether playerName is in diamond group

    if (groupName.equalsIgnoreCase("LEATHER") && !isIron && !isDiamond) {
        // Return true for leather if the player name is not in the iron and diamond group
        return true; 
    } else if (groupName.equalsIgnoreCase("IRON") && isIron && !isDiamond) {
        // Return true for iron if the player name is in the iron group but not in the diamond group
        return true;
    } else if (groupName.equalsIgnoreCase("DIAMOND") && !isIron && isDiamond) {
        // Return true for diamond if the player name is in the diamond group but not in the iron group
        return true;
    }
    return false; // In any other case return false (player could be in both lists, or invalid groupName)
}