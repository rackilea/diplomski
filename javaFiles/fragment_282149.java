// In the ContentProvider
_id = db.insertOrThrow(PMContract.MedicationEntry.TABLE_NAME, null, values);

// In the Dialog Fragment
try{
    getActivity().getContentResolver().insert(PMContract.MedicationEntry.CONTENT_URI, values);
    dismiss();
} catch(SQLiteConstraintException e){
    Toast.makeText(getActivity(), "A medication with this name and strength already exists.", Toast.LENGTH_SHORT).show();
} catch(UnsupportedOperationException uoe){
    Toast.makeText(getActivity(), "Unable to insert new medication.", Toast.LENGTH_SHORT).show();
}