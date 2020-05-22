private static void printPeriod(Info[] max, int count, Writer fileWriter) {
    fileWriter.append(max[0].time);
    fileWriter.append(COMMA_DELIMITER);
    fileWriter.append(max[0].mod);
    fileWriter.append(COMMA_DELIMITER);
    fileWriter.append(max[0].lat);
    fileWriter.append(COMMA_DELIMITER);
    fileWriter.append(max[0].lon);
    fileWriter.append(COMMA_DELIMITER);
    fileWriter.append(max[0].alt);
    for (int i = 0; i < count; ++i) {
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(max[i].wifi);
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(max[i].mac);
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(Integer.toString(max[i].frq));
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(max[i].signal);
    }
    fileWriter.append(NEW_LINE_SEPARATOR);
}