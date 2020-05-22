private Object catcher;
//lots of non-related code here

//directoryList is a returned list of selected directories, that I wish to
//retain in the event of an orientation state change.
String[] directoryList = new String[arrayList.size()];
arrayList.toArray(directoryList);

//here, I set the class Object catcher to the directoryList
catcher = directoryList;

//rest of non-related code

//this method is called when the orientation changes (for me,
//when I open my Droid's hardware keyboard)
public Object onRetainNonConfigurationInstance()
{
    //If I've entered anything into my catcher Object, it will be kept
    //across orientation changes.
    final Object data = catcher;
    return data;
}