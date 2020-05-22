for (int i = 24; i < 30; i++) {   
        if (rowData.size() > i){         
            sb.append(rowData.get(i).trim());
            sb.append(i <= 29 ? "|" : "");
        }
    }