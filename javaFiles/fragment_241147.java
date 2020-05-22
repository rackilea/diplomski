function get_static_pointer_table_id($lat, $lng)
{
    $earth_circumference = 40000; // km

    $lat_bin = round($lat / 0.0009);
    $lng_length = $earth_circumference * cos(deg2rad($lat));
    $number_of_bins_on_lng = $lng_length * 10;
    $lng_bin = round($number_of_bins_on_lng * $lng / 360);
    //the 'bin' unique identifier
    return $lat_bin . "_" . $lng_bin;

}