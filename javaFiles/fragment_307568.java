if(resultSupplierName.next()) {
     p.setSupplierName(resultSupplierName.getString("supplier_name"));
 }
 if(resCat.next()) {
     p.setCategoryName(resCat.getString("category_name"));
 }