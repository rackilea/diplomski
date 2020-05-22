for(int i=1;i<=numColums;++i){
        if (i>numColums){
            System.out.print(result.getString(rmeta.getColumnName(i))+"|");;
        }else {
            System.out.println(result.getString(rmeta.getColumnName(i)));
        }
    }