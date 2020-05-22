boolean finded = false;
for (BasicNameValuePair pair : mPostPairs) {
    if (pair.getName().equals("action")) {
        finded = true;
        break;
    }
}
if (finded)
    return mPostPairs;
else
    throw new IllegalArgumentException(TAG + ": There is no 'action' defined in the collections");