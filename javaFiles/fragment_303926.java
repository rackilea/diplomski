for(i = 0; i < rows; i++){ // iterate through row
            for(j = 0; j < columns; j++){ // iterate through column
                while((line = bufferedReader.readLine())!= null){ // while the next line is not null
                    array[i][j] = line; // assign i-th j-th index as line (the input)
                    // System.out.println(array[i][j]);
                    count++;
                }
            }
        }