$stmt = $dbh->prepare("SELECT  name, lat, lng, ( 3959 * acos( cos( radians(?) ) * cos( radians( lat ) ) * cos( radians( lng ) - radians(?) ) + sin( radians(?) ) * sin( radians( lat ) ) ) ) AS distance FROM gbstn HAVING distance < ? ORDER BY distance LIMIT 0 , 20");
    // Assign parameters
    $stmt->bindParam(1,$center_lat);
    $stmt->bindParam(2,$center_lng);
    $stmt->bindParam(3,$center_lat);
    $stmt->bindParam(4,$radius);