public static void main(String[] args) {

          int k=0;
          String[] s = new String[20];
            String[] values = { "A", "B", "C", "D" };
            final int amount = 2;
            for (int i = 0; i < values.length; i++){

                 for (int j = 0; j < amount; j++){ //data of values as much as amount
                  s[k++] = String.format("%s%04d", values[i], k); 
                 }
            }
            System.out.println(Arrays.toString(Arrays.copyOf(s,k)));
     }