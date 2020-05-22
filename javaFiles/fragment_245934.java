public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] correct1 = {20, 20, 13, 15, 22, 18, 19, 21, 23, 25};
    int[] incorrect1 = {2, 1, 5, 2, 2, 5, 8, 1, 0, 0};

        double[] percentage1 = new double[correct1.length];
        DecimalFormat df = new DecimalFormat("#.##");
        for(int a = 0; a < correct1.length; a++ ){ 
                 percentage1[a] = Double.valueOf(df.format((((double)correct1[a] / (correct1[a] + incorrect1[a]))*100)));
                 System.out.println(percentage1[a]);
            }

}