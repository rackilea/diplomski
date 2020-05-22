public class DeleteAccountActivity extends AppCompatActivity implements DeleteUserFragment.DeleteCompletedCallback {

   public void onDeleteCompleted() {
      Intent intent = new Intent(DeleteAccountActivity.this,RegisterAccountActivity.class);
      startActivity(intent);
      finish();
   }       
}