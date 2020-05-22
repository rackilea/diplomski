public static void main (String [] args) {
        try {
            int l = 14;
            int hold[] = new int[1000];

            int list [] = new int[l];
            for(int i=0;i<=l-1 ;i++){
                list[i] = hold[i];
            }

            for(int i=0;i<list.length;i++){
                System.out.println(list[i]);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }