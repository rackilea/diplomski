BufferedReader brr = new BufferedReader(new FileReader(inFile));
            //now read and store in 2D matrix
            int[][][] samples = new int[inVals.get(1)][rows][cols];
            int index = 0;
            while((lines = brr.readLine()) != null) {
                if (curr > 2) {                    
                    if (lines.equals("")) {
                            index++; //increment the pair we're on
                        }
                            for (int j = 0; j < rows; j++) {
                                for (int k = 0; k < lines.length(); k++) {
                                    //Cycle through each character in line
                                    if (lines.charAt(k) == 'O' || lines.charAt(k) == '0') {
                                        samples[index][j][k] = 1;
                                    }
                                    else if (lines.charAt(k) == ' ') {
                                        samples[index][j][k] = -1;
                                    }
                                }
                            }
                    }
                    curr++; //for the current line we're reading
                }
                brr.close(); //close buffered reader