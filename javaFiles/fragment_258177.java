public class GetNoteTask extends AsyncTask<MainActivity.MyTaskParams,Void , String> {

public String noteContent(EvernoteNoteStoreClient noteStoreClient, String guid) throws EDAMUserException, EDAMSystemException, TException, EDAMNotFoundException {
        String noteText;
        noteText = noteStoreClient.getNoteContent(guid);
        return noteText;
    }


protected String doInBackground(MainActivity.MyTaskParams... params) {

    String noteContent = null;
    String guid = params[0].guid;
    EvernoteNoteStoreClient noteStoreClient = params[0].noteStore;
    try {

        noteContent = noteContent(noteStoreClient, guid);
    } catch (EDAMUserException e) {
        e.printStackTrace();
    } catch (EDAMSystemException e) {
        e.printStackTrace();
    } catch (TException e) {
        e.printStackTrace();
    } catch (EDAMNotFoundException e) {
        e.printStackTrace();
    }
    return noteContent;
}