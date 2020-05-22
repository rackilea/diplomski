public void processData(List<String[]> content) {

    int index=0;
    for (String[] rowData: content){
        //initialize array of objects   
        //o[index] = new Client();

        //use setters to populate your array of objects
        o[index].setID(rowData[0]);
        o[index].setAge(rowData[1]);
        o[index].setRegion(rowData[3]);
        o[index].setSex(rowData[2]);
        o[index].setIncome(rowData[4]);
        o[index].setMarried(rowData[5]);
        o[index].setChildren(rowData[6]);
        o[index].setCar(rowData[7]);
        o[index].setSave_Act(rowData[8]);
        o[index].setCurrent_Act(rowData[9]);
        o[index].setMortgage(rowData[10]);
        o[index].setPep(rowData[11]);

        System.out.println(rowData);

        index++;
        }
}