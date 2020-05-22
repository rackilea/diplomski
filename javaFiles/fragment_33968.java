$qry = $db->prepare('
  INSERT INTO Dashboard (
     script_name,  version,  runtime,  status,  ranged,  attack,
     defense,  strength,  magic,  session_id,  username
  ) VALUES (
    :script_name, :version, :runtime, :status, :ranged, :attack,
    :defense, :strength, :magic, :session_id, :username
  ) ON DUPLICATE KEY UPDATE
    runtime  = runtime  + VALUES(runtime),
    attack   = attack   + VALUES(status),
    defense  = defense  + VALUES(defense),
    strength = strength + VALUES(strength),
    magic    = magic    + VALUES(magic)
');

$qry->execute([
  ':script_name' => $script_name,
  ':version'     => $version,
  ':runtime'     => $runtime,
  ':status'      => $status,
  ':ranged'      => $ranged,
  ':attack'      => $attack,
  ':$defense'    => $defense,
  ':strength'    => $strength,
  ':magic'       => $magic,
  ':session_id'  => $sessionID,
  ':username'    => $username
]);