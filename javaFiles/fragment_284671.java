for (int i = 0; i < input1.length; i++)
{
    String[] temp = input1[i].split("#");
    int first = Integer.parseInt(temp[0]) - 1;
    int second = Integer.parseInt(temp[1]) - 1;
    matrix[first][second] = "1";
    matrix[second][first] = "1";
}