Text rowId = new Text("m0");
Text colFam = new Text("purchase");
Text colQual = new Text("gas");
Mutation mut = new Mutation(rowId);
mut.putDelete(colFam, colQual);

writer = connection.createBatchWriter(tableName, new BatchWriter());
try{
    writer.addMutation(mut);
}catch{
   ...
}