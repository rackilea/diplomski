public function gettemples($latitude, $longitude, $distance, $templetype, $limitno){
        $this->connect();
        // $query = "SELECT * FROM temples";

        $query = "SELECT *, ( 6371 * acos( cos( radians(".$latitude.") ) * cos( radians( latitude ) ) * 
            cos( radians( longitude ) - radians(".$longitude.") ) + sin( radians(".$latitude.") ) * 
            sin( radians( latitude ) ) ) ) AS distance FROM temples HAVING
            distance < ".$distance." ORDER BY distance LIMIT 0 , ".$limitno."";
                $stmt = $this->connection->prepare($query);
                $result = $stmt->execute();
                $results = $stmt->fetchAll(PDO::FETCH_ASSOC);
                return $results;
    }