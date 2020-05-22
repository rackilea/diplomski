$mysqli->autocommit(FALSE);
//do the inserting
if (!$mysqli->commit()) {
print("Transaction commit failed\n");
exit();
}