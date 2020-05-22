String sql = "SELECT aa.Barcode, aa.ItemName, SUM(aa.Quantity) AS Qty\n" +
                    "FROM\n" +
                    "(SELECT Barcode, ItemName, Quantity\n" +
                    "FROM PurchaseDetails\n" +
                    "UNION\n" +
                    "SELECT Barcode, ItemName, Quantity\n" +
                    "FROM BarcodePrinting) aa\n " +
                    "GROUP BY aa.Barcode, aa.ItemName";