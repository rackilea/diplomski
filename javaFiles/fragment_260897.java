String[][] content = new String [3][5];
for(int i = 0; i < miniTable.size(); i++)
{
    Car car = miniTable.get(i);
    content[i][0] = car.getName();
    content[i][1] = car.getManufacturer();
    ....
}