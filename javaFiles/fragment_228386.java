// Queries the user dictionary and returns results 
mCursor = getContentResolver().query(
     UserDictionary.Words.CONTENT_URI,   // The content URI of the words table
     mProjection,                        // The columns to return for each row
     mSelectionClause                    // Selection criteria
     mSelectionArgs,                     // Selection criteria
     mSortOrder); // The sort order for the returned rows Table 2  shows how the arguments to


 query(Uri,projection,selection,selectionArgs,sortOrder) match an SQL
 SELECT statement:


// column names for above provider:
0: _id
1: thread_id
2: address
3: person
4: date
5: protocol
6: read   
7: status
8: type
9: reply_path_present
10: subject
11: body
12: service_center
13: locked