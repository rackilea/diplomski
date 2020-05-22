List<Object[]> lista = query.list();

      for(Object[] row:lista) {
        System.out.println(row[0]);//Object of the first column
        System.out.println(row[1]);//Object of the second column
       }