private List<List<String>> createStructuredParameterArray(String vmlParameter){

        int totalParameterCount = 0;

        String currentXorYParameter = "";
        List<String> listOfParameters = new ArrayList<String>();
        boolean previousIsComma = false;
        boolean firstRun = true;
        for(int i = 0; i < vmlParameter.length(); i++){
            if (i != 0)
                firstRun = false;
            char nextChar = vmlParameter.charAt(i);
            if (nextChar == '@'){
                /**
                 * check the currentXorYParameter if it is a valid format already, 
                 * <br> if True - then proceed to handling the next parameter 
                 * <br> ex. from handling X parameter to Y parameter
                 * <br> ex. from handling Y parameter to X parameter  
                 */
                if (checkIfValidSingleParameter(currentXorYParameter)){
                    totalParameterCount++;
                    listOfParameters.add(currentXorYParameter);
                    currentXorYParameter = "";
                    currentXorYParameter= currentXorYParameter+nextChar;    
                }else{
                    currentXorYParameter= currentXorYParameter+nextChar;    
                }
                previousIsComma = false;
            }else if (nextChar != '@' && nextChar != ','){ //numeric character
                currentXorYParameter= currentXorYParameter+nextChar;
                previousIsComma = false;
            }else if (nextChar == ','){
                if (checkIfValidSingleParameter(currentXorYParameter)){
                    totalParameterCount++;
                    listOfParameters.add(currentXorYParameter);
                    currentXorYParameter = "";
                }else{
                    if (firstRun){
                        totalParameterCount++;
                        currentXorYParameter = "0";
                        listOfParameters.add(currentXorYParameter);
                        currentXorYParameter = "";
                        firstRun = false;
                    }
                }
                if (previousIsComma){
                    totalParameterCount++;
                    currentXorYParameter = "0";
                    listOfParameters.add(currentXorYParameter);
                    currentXorYParameter = "";
                }
                previousIsComma = true;
            }
            if ((i+1)==vmlParameter.length()){
                if (checkIfValidSingleParameter(currentXorYParameter)){
                    totalParameterCount++;
                    listOfParameters.add(currentXorYParameter);
                    currentXorYParameter = "";
                    /**
                     * check if parameterCounter is odd or even, 
                     * <br> if odd  - add additional "0" to make it even
                     * <br> if even - do nothing
                     */
                    if ((totalParameterCount % 2)==1){
                        listOfParameters.add("0");
                    }
                }
            }
        }
        if ((listOfParameters.size()%2)==1){
            listOfParameters.add("0");
        }
        /**
         * Group the parameters by 2 in a List<String> object
         * <br>List<String> object
         *      <bR> object.add("\<value here\>"); => for x coordinate
         *      <bR> object.add("\<value here\>"); => for y coordinate
         * 
         * <br>Then create a list of all List<String> object created from above
         * <br> uncomment below if the desired result return value is as described above 
         */
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        if(listOfParameters.size()>1){
            int counter = 1;
            for (int i = 0; i<listOfParameters.size(); i++){
                String xyCoordinate = listOfParameters.get(i);
                if ((counter%2)==1){ //X coordinate
                    temp.add(xyCoordinate);
                }else if ((counter%2)==0){ //Y coordinate
                    temp.add(xyCoordinate);
                    result.add(temp);
                    //temp.clear();
                    temp = new ArrayList<String>();
                }
                counter++;
            }
        }

        return result;

    }