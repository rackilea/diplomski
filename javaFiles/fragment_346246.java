while (X == true && flag == true) {
        input = JOptionPane.showInputDialog("Tell me more about " + topics[z]);
        String temp = input;
        parts = new String[initialArraySize];

        if (input != null) {
            parts = temp.split(" ");
            flag = true;
        }
        else if (input == null) {
            flag = false;
        }



        for (int i = 0; i < parts.length; i++) {
            for (int x = 0; x < topics.length; x++) {
                if (parts[i].equals(topics[x])) {
                    cut = parts[i];
                    break;
                }
            }
        }
        for (int i = 0; i < topics.length; i++) {
            if (cut.equals(topics[i])) {
                z = i;
                break;
            }

        }

        input = cut;
        System.out.print(cut);
        System.out.println(z);

        X = Arrays.asList(topics[z]).contains(input);
        System.out.println(X);

    }