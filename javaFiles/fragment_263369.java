int batchSize = 50;
int batchCounter=0;
for(int i=startRange;i<=endRange;i++){

String key = tablePrefix+i;
Delete d=new Delete(Bytes.toBytes(key));
listOfBatchDelete.add(d);  
batchCounter++;

if(batchCounter==batchSize){
    try {
        table.delete(listOfBatchDelete);
        listOfBatchDelete.clear();
        batchCounter=0;
    }
}}