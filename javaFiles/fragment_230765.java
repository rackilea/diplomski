String test1 = "this group doesn not exists";
    if (!database.classDao().doesGroupExist(test1)) {
        Log.d("GROUPLOOKUPRESULT","Group " + test1 + " Not located.");
    } else {
        Log.d("GROUPLOOKUPRESULT","Group " + test1 + " Located.");
    }
    String test2 = "myfirstid";
    if (database.classDao().doesGroupExist(test2)) {
        Log.d("GROUPLOOKUPRESULT","Group " + test2 + " Located.");
    } else {
        Log.d("GROUPLOOKUPRESULT","Group " + test2 + " Not Located.");
    }