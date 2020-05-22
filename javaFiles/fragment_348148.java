ArrayList<String> input = (ArrayList<String>) Files.readAllLines(f.toPath(), StandardCharsets.US_ASCII);
ArrayList<String> output = new ArrayList<String>();

boolean matched = false;
for (String line : input) {
    if (line.equals("###---###") && matched) matched = false; //needed parentheses
    if (matched) output.add(line);
    if (line.equals("###Test File###") && !matched) matched = true;
}