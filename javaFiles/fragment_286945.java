String sql1="update Item_detail
                   set Available=Available-?
             where
                   P_name=? 
               and Manuf_name =?
               and Model_no=?";