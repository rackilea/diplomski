for(i = row.getLastCellNum();i>=0;i--){
        if(row.getCell(i)!=null){
            if(!row.getCell(i).toString().isEmpty())
                break;
        }
    }//now i is the last cell number which is not blank.