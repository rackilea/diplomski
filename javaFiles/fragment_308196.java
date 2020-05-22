ArrayList<ContentProviderOperation> operationList = new ArrayList<ContentProviderOperation>();
ContentProviderOperation contentProviderOperation;

for (/*loop over your arrayList*/) 
{
    contentProviderOperation = ContentProviderOperation.newDelete(Events.CONTENT_URI).withSelection(Events._ID + " =? ", new String[]{yourId}).build();
    operationList.add(contentProviderOperation);
}

try {
    getContentResolver().applyBatch(Contract.AUTHORITY, operationList);
} 
// catch the exceptions