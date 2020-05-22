String sql = "exec my_stored_procedure\n@parameter_1 = ?,\n@parameter_2 = ?,\n@parameter_9 = ?";

PreparedStatement stmt = ...
stmt.setString( 1, "ONE" );
stmt.setString( 2, "TWO" );
stmt.setString( 3, "NINE" );
stmt.execute();