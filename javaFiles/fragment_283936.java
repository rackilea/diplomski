public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        char[][] cypher = {
            {'p', 'h', '0', 'q', 'g', '6'},
            {'4', 'm', 'e', 'a', '1', 'y'},
            {'l', '2', 'n', 'o', 'f', 'd'},
            {'x', 'k', 'r', '3', 'c', 'v'},
            {'s', '5', 'c', 'w', '7', 'b'},
            {'j', '9', 'u', 't', 'i', '8'}};

        char[] data = {'w', 'o', 'r', 'l', 'd'};//data convert to char array

        for (char c : data) {
            for (int i = 0; i < cypher.length; i++) {
                char[] cs = cypher[i];
                for (int j = 0; j < cs.length; j++) {
                    char d = cs[j];
                    if (d == c) {
                        sb.append(i);
                        sb.append(j);
                        sb.append(" "); 
                    }

                }

            }
        }
        System.out.println(sb.toString());
    }