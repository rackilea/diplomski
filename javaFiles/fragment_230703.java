while (splitLine.length != 4) {
    line = reader.readLine();
    stringBuilder.append(line);

    splitLine = stringBuilder.toString().split("\t");
}