QueryString = "INSERT IGNORE INTO stock_prices
(symbol,timestamp,open,high,low,close,vol) VALUES 
       ('"
       + data[0] + "', '" + data[1] + "', '" 
       + data[2] + "', '" + data[3] + "', '" 
       + data[4] + "', '" + data[5] + "', '" 
       + data[6] + "'
       )";