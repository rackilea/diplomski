String[] strings = new String[numStrings];
...
for (int i = 0; i < numStrings; i++) {
            System.out.println("Number of strings from string " + (i + 1) + ": ");
            String nextLine = console.next();
            strings[i] = nextLine;
            sum += strings[i].length();
        }
...
for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() > average) {
                above++;
            }
        }