for(int j=0; j<tableData[0].length; j++){
    if(j==2)
        tableData[i][j] = new TablePercentValue(i+","+j+"%");
    else if(j == 1)
        tableData[i][j] = i+":"+j;
    else
        tableData[i][j] = i+""+j;
    tableData[i][j] = value;
}