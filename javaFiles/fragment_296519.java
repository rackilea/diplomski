//generating a subset of 90 eight character strings (unique deletion patterns)
    public static String[] gen8String(String[] pattern1, String[] pattern2){
        String[] combinedSubset = new String[90]; //emty array for the subset of 90 strings
        String  combinedString = ""; //string holder for each combined string
        int index = 0; //used for combinedSubset array
        int present = 0; //used to check if all 6 characters are present

        for(int i = 0; i < 15; i++){

            for(int j = 0; j < 15; j++){
                combinedString = pattern1[i] + pattern2[j]; //combine both 4 letter strings into 8 char length string
                char[] parsedString = combinedString.toCharArray(); //parse into array

                //check if all 6 characters are present
                for(int k = 1; k <= 6; k++)
                {
                    if(new String(parsedString).contains(k+"")) {
                        present++;
                    }
                    else
                        break;
                    //if all 6 are present, then add it to combined subset
                    if(present == 6)
                        combinedSubset[index++] = combinedString;
                }
                present = 0;
            }
        }
        return combinedSubset;
    }