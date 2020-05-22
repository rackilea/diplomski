int[][] temp = {{2,1,0},{2,8,9},{1,1,0}};
        Arrays.sort(temp, new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(b[1], a[1]);
        }
        });
        System.out.println("After applying comparator");
        for(int[] arr:temp){
            for(int val:arr){
                System.out.print(val+" ");
            }
            System.out.println("");
        }