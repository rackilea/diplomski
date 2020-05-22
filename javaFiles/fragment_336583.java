SELECT measurement.name
    , measurement_data_points.data_points_id
    , measurement_point.date
    , measurement_point.f1
    , measurement_point.precison
    , measurement_point.recall
FROM measurement 
LEFT JOIN measurement_data_points  ON measurement.measurement_id= measurement_data_points.measurement_id
LEFT JOIN measurement_point ON measurement_data_points.data_points_id = measurement_point.id ;