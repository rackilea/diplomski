String [] prod_list = request.getParameterValues("prod");
String [] desc_list = request.getParameterValues("desc");
// set up your query

PreparedStatement prep = connection.prepareStatement(sql);

// just a precaution here getting min so we do not get outofbounds exception on one of the arrays
// both arrays should be of same size - if not, something is wrong on your jsp logic
int num_values = Math.min(prod_list.size(), desc_list.size());

int count_updated = 0;
for(int i = 0; i < num_values; i++){
    prep.setString(1, brand_name);
    prep.setString(2, prod_list[i]);
    prep.setString(3,desc_list[i]);
    count_updated += prep.executeUpdate();
}

// Rest of your logic