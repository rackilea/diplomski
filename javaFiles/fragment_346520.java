@Override
    public String toString() {
        StringBuilder phoneBook = new StringBuilder();  
        //Generate comma separated entries of phone book  
        for (int i = 0; i < phoneNumbers.length && i < phoneTypes.length; i++ ) {
            if (i > 0) { 
                phoneBook.append(','); 
            }
            phoneBook = phoneBook.append(phoneNumbers[i])
                                 .append(':')
                                 .append(phoneTypes[i])

        }

        return phoneBook.toString();  
    }