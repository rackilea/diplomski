/**
 * This is method to display dialog with three
 * button("Yes, No and Cancel button")
 */
public void showThreeButtonDialog()
{
    private AlertDialog m_alertDialog;
    private AlertDialog.Builder m_builder = new AlertDialog.Builder(this);
    m_builder.setTitle("Title Text");
    m_builder.setMessage("Dialog Message");
    m_builder.setPositiveButton("yes", new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface p_dialog, int p_which)
        {
            Toast.makeText(AlertDialogActivity.this, "Press Yes", Toast.LENGTH_SHORT).show();
        }
    });
    m_builder.setNeutralButton("No"), new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface p_dialog, int p_which)
        {
            Toast.makeText(AlertDialogActivity.this, "Press No", Toast.LENGTH_SHORT).show();
        }
    });
    m_builder.setNegativeButton("Cancel"), new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface p_dialog, int p_which)
        {
            Toast.makeText(AlertDialogActivity.this, "Press Cancel", Toast.LENGTH_SHORT).show();
        }
    });
    m_alertDialog = m_builder.create();
    m_alertDialog.show();
}