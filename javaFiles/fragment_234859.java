public void search()
        { 
            PreparedStatement stmt = null;
            String query = "select bnse.* from bhav_NSE bnse,Nat_Support nsup where bnse.symbol=nsup.symbol and nsup.symbol is not null";
            stmt   = DBHelper.getInstance().getConn().prepareStatement(query);
             ResultSet res = stmt.executeQuery();

                while(res.next()){
                    // Get data res.getString(..);
                }
                res.close();
            }
            rs.close();

        }