$return_arr = array();

$fetch = mysql_query("SELECT category, category_color FROM categories ORDER BY category"); 

while ($row = mysql_fetch_array($fetch, MYSQL_ASSOC)) {
    $row_array['category'] = $row[0];
    $row_array['category_color'] = $row[1]; 


    array_push($return_arr,$row_array);
}

echo json_encode($return_arr);