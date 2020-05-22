public class FormsMultipleSelectCustomJava extends AppCompatActivity {

   String selectItensServer;  
   String[] selectInitItens;
   ArrayList<ALItensValues> AlertDialogitemList = new ArrayList<>();
   ArrayList<ALItensValues> selectedItemsList = new ArrayList<>();

   @Override
   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multipleselectcustom);

        selectItensServer = "0b2,0e5,0f6,0h8";  
        selectInitItens = selectItensServer.split(",");

        AlertDialogitemList.add(new ALItensValues(R.drawable.atrib_bicycle, "0a1", "Test 1", "Lorem ipsum dolor sit amet", true));
        AlertDialogitemList.add(new ALItensValues(R.drawable.atrib_btc, "0b2", "Test 2", "Duis at ullamcorper quam", true));
        AlertDialogitemList.add(new ALItensValues(R.drawable.atrib_car, "0c3", "Test 3", "Aenean aliquam sit amet nibh eget bibendum", false));
        AlertDialogitemList.add(new ALItensValues(R.drawable.atrib_credit_card, "0d4", "Test 4", "Sed a est vel velit rutrum porta", true));
        AlertDialogitemList.add(new ALItensValues(R.drawable.atrib_gamepad, "0e5", "Test 5", "Phasellus pellentesque arcu et fermentum tempus", false));
        AlertDialogitemList.add(new ALItensValues(R.drawable.atrib_gift, "0f6", "Test 6", "Integer arcu leo, consequat eget tempus sed", true));
        AlertDialogitemList.add(new ALItensValues(R.drawable.atrib_paypal, "0g7", "Test 7", "Pellentesque habitant morbi tristique senectus", false));
        AlertDialogitemList.add(new ALItensValues(R.drawable.atrib_taxi, "0h8", "Test 8", "Proin iaculis, velit ac consectetur bibendum, orci nisi scelerisque", true));
        AlertDialogitemList.add(new ALItensValues(R.drawable.atrib_utensils, "0i9", "Test 9", "Ut ullamcorper nisi dui, et sagittis ante mollis vitae", false));
        AlertDialogitemList.add(new ALItensValues(R.drawable.atrib_whatsapp, "k10", "Test 10", "Donec rhoncus magna in mauris ultricies", true));

      Button btnopendialog = findViewById(R.id.btnopendialog);
      btnopendialog.setOnClickListener(v -> {
             AlertDialog.Builder dialogbuider = new AlertDialog.Builder(context);
             dialogbuider.setCancelable(false);
             dialogbuider.setTitle("Itens");
             ALItensValuesAdapter mAdapter = new ALItensValuesAdapter(ALitensvalues, context, new MyInterface() {
               @Override
               public void onItemChecked(int position) 
                 {
            AlertDialogitemList.get(position).setChecked(!AlertDialogitemList.get(position).getChecked())
                 }
              });
            dialogbuider.setAdapter(mAdapter, (dialog, which) -> {

            });
            dialogbuider.setPositiveButton("OK", (dialogInterface, which) -> {

            });
            dialogbuider.setNeutralButton("Clear", (dialogInterface, which) -> { 
            });
            AlertDialog dialog = dialogbuider.create();
            ListView listView = dialog.getListView();
            listView.setDivider(new ColorDrawable(Color.GRAY)); 
            listView.setDividerHeight(2);
            dialog.show();
       });


         findViewById(R.id.btnsend).setOnClickListener(v -> {
             for(ALItensValues item : AlertDialogitemList) {
                  if(item.isChecked()) {
                       selectedItemsList.add(item);
                  }
             }
            // selected items can be sent to server
      });
   }
}