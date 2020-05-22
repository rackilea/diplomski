StringBuilder result = new StringBuilder();

for (int i = 0; i < Temperature[0].length; i++) {
    columnTotal = 0;

    for (int j = 0; j < Temperature.length; j++) {           
       columnTotal = columnTotal + Temperature[j][i];
    }   

   result.append(columnTotal / 4).append(" ");
}

System.out.println(result);