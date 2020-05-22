String query = "INSERT INTO TotalSales (Date, Sales) VALUES(?, ?)
                    ON DUPLICATE KEY UPDATE Sales= VALUES(Sales)+?";
st = con.prepareStatement(query);
st.setDate(1, date);
st.setLong(2, totalBill);
st.setLong(3, totalBill);