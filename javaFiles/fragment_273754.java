IntStream.range(24, 29).forEach(i ->
    {            
        if (rowData.size() > i){         
            sb.append(rowData.get(i).trim());
            sb.append(i <= 29 ? "|" : "");
        }
    });