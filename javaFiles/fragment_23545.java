if (deals != null && !deals.isEmpty()) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:as400://localhost/BB",
                    "<username>",
                    "<password>");
            PreparedStatement preparedStatement = null;
            String sql;
            if (allDealsCreated) {
                System.out.println("Updating the status of the deals as CLOSED");
                sql = "UPDATE DEALS SET STATUS = 'CLOSED' WHERE DEALNO= ?";
            } else {
                System.out.println("Updating the status of the deals as NEW");
                sql = "UPDATE DEALS SET STATUS = 'NEW' WHERE DEALNO= ?";
            }                    
            preparedStatement = con.prepareStatement(sql);
            for (String dealId : deals) {
                preparedStatement.setString(1, dealId);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }