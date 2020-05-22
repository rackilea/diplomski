try (PreparedStatement $preparedStatement$ = $connect$.prepareStatement($sql$)) {
    $code1$;
    try (ResultSet $resultSet$ = $preparedStatement$.executeQuery()) {
        $code2$;
        if ($resultSet$.next()) {
            $code3$;
        }
    }
}