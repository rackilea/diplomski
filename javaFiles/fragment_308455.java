public static boolean isValid(String password) {  
        if (password.length() < 10) {   
            return false;  
        } else {      
            char c;  
            int digitCount, letterCount;   
            for (int i = 0; i < password.length(); i++) {  
                c = password.charAt(i);  
                if (Character.isLetter(c)) {          
                    letterCount++; 
                } else if (Character.isDigit(c))   
                    digitCount++;      
            }  
            if(digitCount < 1 || lettercount < 1) { return false; }
        }  
        return true;  
    }