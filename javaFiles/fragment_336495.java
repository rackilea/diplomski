String input = "1234567891245752";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
           if (i % 4 == 0 && i != 0) {
              result.append(" ");
            }

           result.append(input.charAt(i));
        }

        System.out.println(result.toString());