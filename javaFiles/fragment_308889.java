String query = "Update PS 
            set ShelfNumber = "+edittextshelf+
            " from file.ItemPart PS "+
            " join file.item P on P.id = PS.id "+
            " where P.ItemNumber = '"+edittextitem + "'";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();