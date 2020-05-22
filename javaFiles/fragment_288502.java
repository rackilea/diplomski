while ((sCurrentLine = br.readLine()) != null) {

                    array[i]= Integer.parseInt(sCurrentLine);
                    i++;
                }


            for(int j=0;j<array.length;j++){
                System.out.println(array[j]);
            }