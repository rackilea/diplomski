$Statement = oci_parse(
    $Connection,
    'select * from Company where address = :un_bv and email = :pw_bv'
);

oci_bind_by_name($Statement, ":un_bv", $_POST['username']);
oci_bind_by_name($Statement, ":pw_bv", $_POST['password']);

oci_execute($Statement);
$r = oci_fetch_array($Statement, OCI_ASSOC);