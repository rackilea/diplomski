public static void print_player_info(String[][] data, String player){
    // lower case the search string
    String searchString = player.toLowerCase();
    // check every row in the data table except the first
    // because it has the column names in it.
    for(int row = 1; row < data.length; row++){
        // get the player name in this row
        String playerInThisRow = data[row][0];
        // lower case it and check if it contains the search string
        if(playerInThisRow.toLowerCase().contains(searchString)){
            // go throu every column in this row
            for(int column = 0; column < data[0].length; column++){
                // and get the column name and the content
                String columnContent = data[row][column];
                String columnName = data[0][column];        
                // and print it
                System.out.println(columnName +": " + columnContent);
            }  
        }
    }
 }