public static void main(String[] args) {
        String[] input = new String[]{
                "a", "a", "a", "a", "b", "b", "b", "b", "c", "c", "c", "c"
        };
        // here we'll generate the output
        String[] output = new String[input.length];
        // how many different characters do we have?
        int characters = 0;
        for (int i = 1; i < input.length; i++) {
            if (!input[i - 1].equals(input[i])) {
                break;
            } else {
                characters++;
            }
        }
        // how many times each character appears
        int times = input.length / characters;
        // different characters to shuffle
        String[] toShuffle = new String[characters];
        int m = 0;
        while (times * m < input.length) {
            toShuffle[m] = input[times * m];
            m++;
        }
        // for each position in output
        for (int i = 0; i < output.length;) {
            // define a list with all different characters
            List<String> remain = new ArrayList<>(Arrays.asList(toShuffle));
            // set a random character without repetition
            int j = 0;
            while (j < characters) {
                int pos = 0;
                // after {characters} we have a chance of repetition so we check
                if(i % characters == 0 && i != 0) {
                    do {
                        pos = Double.valueOf(Math.random() * remain.size())
                                .intValue();
                    } while (output[i-1].equals(remain.get(pos)));
                } else {
                    pos = Double.valueOf(Math.random() * remain.size())
                            .intValue();
                }
                // assign a character
                output[i] = remain.get(pos);
                // remove from possible chars to not repeat
                remain.remove(pos);
                j++;
                i++;
            }
        }
        // this is the solution
        System.out.println(Arrays.toString(output));
    }