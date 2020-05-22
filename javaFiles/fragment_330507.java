for (int i = 0; i < output.length; i++) {
            output[i] = output[i].replaceAll("\\.", ""); //Add this line (or use a new variable)
            if (hashmap.containsKey( output[i]) ) {
                output[i] = hashmap.get(output[i]);
            }
            System.out.print(output[i]);
            if (i != output.length - 1) {
                System.out.print(" ");
            }
        }