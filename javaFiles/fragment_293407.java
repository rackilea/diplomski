int index = 0;

while (true) {
    if (!((line = br.readLine()) != null)) break;
    String[] splitted = line.split(",");
    country[index] = splitted[0];
    timescale[index] = splitted[1];
    vendor[index] = splitted[2];
    units[index] = splitted[3];
    index++;
}