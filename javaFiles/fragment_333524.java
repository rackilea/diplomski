fileWriter.append(firstColumn);
    fileWriter.append(";");
    for(String column : otherColumns) {
        fileWriter.append(column);
        fileWriter.append(";");
    }