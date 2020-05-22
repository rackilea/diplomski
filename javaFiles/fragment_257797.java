String arrayChars = "";
   for (int i = 0; i < ch.size(); i++) { 
         arrayChars += ch.get(i).toString(); // If youre using an array of strings theres no need to use .toString()
    }
    insert.setString(2, arrayChars);
    insert.executeUpdate();