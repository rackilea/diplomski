String line = br.readLine();
    loadProperties(line);

    while (br.readLine() != null) {
        sb.append(line);
        sb.append("\n");
        line = br.readLine();
    }