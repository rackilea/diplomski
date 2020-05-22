for (int i = 0; i < output.length; i++) {
            String tempStr = output[i].replaceAll("\\.", "");
            if (hashmap.containsKey( tempStr ) ) {
                output[i] = hashmap.get(tempStr);
            }
            System.out.print(output[i]);
            if (i != output.length - 1) {
                System.out.print(" ");
            }
        }