String line;
    int currentLine = 0;

    while ((line = bufferedReader.readLine()) != null) {
        String[] numbers = line.split(" ");

        System.out.println("Linenumber " + currentLine);
        System.out.println(numbers[0]);
        System.out.println(line);
        currentLine ++;
    }
    reader.close();