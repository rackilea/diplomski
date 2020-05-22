for (int i = 0; i < rowsOut; i++){
            createData.writeNewline();
            String lineString = input.nextLine();
            line = lineString.split("\t");
            for (int j = 0; j < columnsOut; j++){
                data[i][j] = Integer.parseInt(line[j]); 
                System.out.print(data[i][j]);   
            } 
        }