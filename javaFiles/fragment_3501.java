PreparedStatement $preparedStatement$ = $connect$.prepareStatement($sql$);
$code1$;
$resultSet$ = $preparedStatement$.executeQuery(); 
$code2$;
if ($resultSet$.next()) {
    $code3$;
} else $nothing$