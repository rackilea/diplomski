String file = "C:/Users/User/Desktop/Test/upload2.csv";

String loadQuery = "LOAD DATA LOCAL INFILE '" + file + "' "
        //---------------------------------------^^
        + "INTO TABLE txn_tbl FIELDS TERMINATED BY ',' "
        + "LINES TERMINATED BY '\n'  " 
        + "IGNORE 1 LINES(txn_amount, card_number, terminal_id)";