String [][] data1 = new String[user_decide.size()][];
int [][] data = new int [user_decide.size()][];

for (int i = 0; i < user_decide.size(); i++){
    data1[i] = decide[i].split("\\,");
    for (int j = 0; j < data1[i].length; j++) {
        data[i] = new int [data1[i].length]; // This line has to be prior to the
        // inner loop, or else you'll overwrite everything but the last number.
        data[i][j] = Integer.parseInt(data1[i][j]);
        System.out.println(data1[i][j]);
    }
}