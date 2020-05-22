WhereClause whereClause = new WhereClause();

if(!(txt_billing2.getText().trim().isEmpty())) {
    whereClause.addParameter("BILLING", txt_billing2.getText().trim());
}

...

if(!(txt_umonth2.getText().trim().isEmpty())) {
    whereClause.addParameter("UMONTH ", txt_umonth2.getText().trim());
}

String sql = "SELECT * FROM airindia_sqlite" + whereClause.getWhereClause();
ps = con.prepareStatement(sql);

Map<Integer, Object> parameters = whereClause.getParameters();
for (Integer key : parameters.keySet()) {
    ps.setObject(key, parameters.get(key));
}

rs = ps.executeQuery();