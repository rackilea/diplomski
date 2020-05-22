String text = "Professor, engineering, data, mining, research";
        StringTokenizer str = new StringTokenizer(text);
        String word[] = new String[10];
        String unique[] = new String[10];
        String x;
        int count = -1;
        while (str.hasMoreTokens()) {
            count++;
            x = str.nextToken();
            word[count] = x;
           System.out.println(count + ": " + word[count]);

        }

        System.out.println("---Frequency---");

        // create unique words
        for (int i = 0; i < 7; i++) {

            if ((!Arrays.asList(unique).contains(word[i]))) {
                unique[i] = word[i];
            }
        }

        // measuring frequency
        int[] measure = new int[10];

        for (int a = 0; a < 7; a++) {
            if (Arrays.asList(unique).contains(word[a])) {
                measure[a] += 1;
                System.out.println(unique[a] + " : " + measure[a]);
            }
        }