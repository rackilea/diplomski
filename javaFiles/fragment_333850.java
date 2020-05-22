long tempId = 0;
while (rows.next()) {
  if (tempId == rows.getLong("id")) {
    // add productN
  } else {
    // add invoice + product1
    tempId = rows.getLong("id");
  }
}