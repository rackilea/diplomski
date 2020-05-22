int [][] data = new int [user_decide.size()][];

for (int i = 0; i < user_decide.size(); i++){
    String[] temp = decide[i].split(",");
    data[i] = new int [temp.length];
    for (int j = 0; j < temp.length; j++){
        data[i][j] = Integer.parseInt(temp[j]);
        System.out.println(data1[i][j]);
    }
}