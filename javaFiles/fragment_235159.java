public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    String dataRow = "1191196800.681";


        String[] dataarray = dataRow.split("-");

        String temp = dataarray[0];
        DecimalFormat df = new DecimalFormat("#.###");
        double i = Double.parseDouble(temp);

        System.out.println(temp);
        System.out.println(df.format(i));

}