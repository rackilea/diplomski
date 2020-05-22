String line = "Stackoverflow is the best.";
        String delimeter = " ";
        final String[] words = line.split(delimeter);
        String reversedLine = "";
        for(int i = words.length - 1; i >= 0; i--) {
            reversedLine += words[i] + delimeter;
        }
        // remove the delimeter present at last of line
        reversedLine = reversedLine.substring(0, reversedLine.length() - 1);
        System.out.println(reversedLine);