br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/smd/Desktop/test.txt"), "UTF-8"));
        String lines = br.readLine();
        ArrayList<String> buffer = new ArrayList<String>();
        //Counter to keep count of line
        int counter = 0;
        while (lines != null) {
            counter++;
            buffer.add("\n");
            /*
             * Check for odd line. If line is odd, revers it, else take the line as it is.
             */
            if (counter % 2 == 0) {
                StringBuilder str = new StringBuilder();
                String[] splitStr = lines.split(" ");
                for (int i = splitStr.length; i > 0; i--) {
                    str.append(splitStr[i - 1]).append(" ");
                }
                buffer.add(str.toString());
            } else {
                buffer.add(lines);
            }
            lines = br.readLine();
        }
        /*
         * Print from buffer. Even buffer.toString() will work, but it appends comma ',' to separate line and add braces to whole string.
         */
        for (int i = 0; i < buffer.size() - 1; i++) {
            System.out.print(buffer.get(i));
        }
        br.close();