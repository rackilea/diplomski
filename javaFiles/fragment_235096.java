public boolean isPerfectSquare(String userInput){
        if(Math.sqrt(Double.parseDouble(userInput)) == Math.round(Math.sqrt(Double.parseDouble(userInput)))){
            return true;
        }
        return false;
    }