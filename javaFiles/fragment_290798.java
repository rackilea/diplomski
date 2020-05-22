class WriteUtils
{
    public static void write(List<Note> editedNotesList, Integer rnID, Context context)
    {
       File notesDB = new File(context.getExternalCacheDir(), "notesDB.txt");
       // and so on.. use context.get... 
    }
}