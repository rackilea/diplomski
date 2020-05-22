public static void saveArray<T>(Connection con, int playerID, String tableName, String fieldName, T[] array, T[] originalArray, TypeDependentBehavior<T> behavior) {
 try {
        for (int i = 0; i < array.length; i++) {
            // Check for change before running query
            if (array[i] != originalArray[i]) {
                if (array[i] != 0 && array[i] != -1) {
                    PreparedStatement updateQuery = con.prepareStatement("REPLACE INTO `" + tableName + "` (`player_id`, `index`, `" + fieldName + "`) VALUES(?, ?, ?)");
                    updateQuery.setInt(1, playerID);
                    updateQuery.setInt(2, i);
                    behavior.setFieldValue(updateQuery, array[i]);
                    updateQuery.execute();
                } else {
                    PreparedStatement deleteQuery = con.prepareStatement("DELETE FROM `" + tableName + "` WHERE `player_id` = ? AND `index` = ?");
                    deleteQuery.setInt(1, playerID);
                    deleteQuery.setInt(2, i);
                    deleteQuery.execute();
                }

                originalArray[i] = array[i];
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(PlayerSaveHandler.class.getName()).log(Level.SEVERE, "SQL Exception while saving an int array!", ex);
    }
}