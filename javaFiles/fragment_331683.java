try(BufferedReader br = new BufferedReader(new FileReader("yourFile.txt"))) {
        StringBuilder builder = new StringBuilder();
        String line = br.readLine();
        Boolean needNextLine = false;

        while (line != null) {
            if (needNextLine) {
                sb.append(line)
                needNextLine = false;
                sb.append(System.lineSeparator());
            }

            if (line.contains("Shiroe")) {     // hardcoded
                 sb.append(line);
                 needNextLine = true;
                 sb.append(System.lineSeparator());
            }

            line = br.readLine();
        }
        String toBeReturned = sb.toString();
    }