Operaiton op = createCluster(...);
while(!op.getDone()) {
    sleep(10);
    op = getOperation(op.getName());
}

if (op.hasError()) {
   // Display op.getError(); 
}