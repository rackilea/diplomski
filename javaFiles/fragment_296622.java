if (!Character.isLetter(s.charAt(0))){
        return isPalindrom(s.substring(1,s.length()));
    }
     if (!Character.isLetter(s.charAt(s.length()-1))){
        return isPalindrom(s.substring(0,s.length()-1));
    }