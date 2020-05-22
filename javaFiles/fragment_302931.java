tx = db.beginTx();
while () {

// do stuff

if (++counter % 1000 == 0) {
   tx.success(); tx.close();
   tx = db.beginTx();
}
}
   tx.success(); tx.close();