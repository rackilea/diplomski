...

        int whiteSpace = 0;

        while (whiteSpace < line.length() && Character.isWhitespace(line.charAt(j))) {
            whiteSpace++;
        }

        String[] tokens = line.split(" ");

        // Print white space
        for (int i = 0; i < whiteSpace; i++) {
            output.print("&nbsp");
        }

        ...