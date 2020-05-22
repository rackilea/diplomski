String[] parameters = {"|","X","Y","Z","Points"}; // OR {"|", "Elevation", "Latitude", "Longitude"};

StringBuilder pattern = new StringBuilder("%s ");
for(int i = 1; i < parameters.length; i++){
    pattern.append("%-15s ");
}
pattern.append("%n");

List<String> divider = new ArrayList<String>();
divider.add("|");
for(int i = 1; i < parameters.length; i++){
    divider.add("---------");
}
stringBuilder.append(String.format(pattern.toString(), parameters));
stringBuilder.append(String.format(pattern.toString(), divider.toArray(new String[0]));