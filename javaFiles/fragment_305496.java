public class TableOrdersActivity extends AppCompatActivity {

public  OrdersInterface datasource1;
android.widget.TableLayout t1;
String Rou = "";
String Typ = "";
String Rou1 = ""; String Typ1 = "";
List<GetSetProductsDetail> l1;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_table_orders);
    Intent ag = getIntent();
    Rou= ag.getStringExtra("Rou");
    Typ= ag.getStringExtra("Typ");
    Rou1= ag.getStringExtra("Rou1");
    Typ1= ag.getStringExtra("Typ1");
    t1= (android.widget.TableLayout) findViewById(R.id.tableorders);
    GetAllProduct("1",Rou1,Typ1);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_client__data__show, menu);
    return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
        return true;
    }

    return super.onOptionsItemSelected(item);
}

public void GetAllProduct(String d, String Rou, String Typ){

    AlertDialog alertDialog = new AlertDialog.Builder(TableOrdersActivity.this).create();
    alertDialog.setTitle("Alert");
    datasource1 = new OrdersInterface(this);
    long rowcount = datasource1.getrowCount();

    if(rowcount == 0 || rowcount < 0){

        alertDialog.setMessage("No Data found go back and get from file");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent a = new Intent(TableOrdersActivity.this, SplashActivity.class);
                        startActivity(a);
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
    else {

        String openresult=  datasource1.openforread();
        if(openresult.equals("1")){

            try {
                int t =0;
                l1 = datasource1.getAllClients(d, Rou, Typ);
                if(l1.size()==0){
                    alertDialog.setMessage("No data according to your Query Go Back..");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent a = new Intent(TableOrdersActivity.this, AfterSplash.class);
                                    startActivity(a);
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                }

                for (GetSetProductsDetail cn : l1) {

                    if(t==0){
                        TableRow row= new TableRow(this);
                        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                        row.setLayoutParams(lp);

                        TextView tv00 = new TextView(this);
                        tv00.setText("Code");
                        tv00.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv00.setTextColor(Color.BLACK);
                        tv00.setTextSize(13);
                        tv00.setGravity(Gravity.CENTER);
                        tv00.setPadding(10, 15, 10, 15);
                        tv00.setBackgroundResource(R.drawable.item);
                        row.addView(tv00);


                        TextView tv111 = new TextView(this);
                        tv111.setText("BarCode");
                        tv111.setTextColor(Color.BLACK);
                        tv111.setGravity(Gravity.CENTER);
                        tv111.setTextSize(13);
                        tv111.setPadding(10, 15, 10, 15);
                        tv111.setBackgroundResource(R.drawable.item);
                        row.addView(tv111);

                        TextView tv22 = new TextView(this);
                        tv22.setText("Name");
                        tv22.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv22.setTextColor(Color.BLACK);
                        tv22.setTextSize(13);
                        tv22.setGravity(Gravity.CENTER);
                        tv22.setPadding(10, 15, 10, 15);
                        tv22.setBackgroundResource(R.drawable.item);
                        row.addView(tv22);

                        TextView tv33 = new TextView(this);
                        tv33.setText("SIZE");
                        tv33.setTextColor(Color.BLACK);
                        tv33.setGravity(Gravity.CENTER);
                        tv33.setPadding(10, 15, 10, 15);
                        tv33.setBackgroundResource(R.drawable.item);
                        tv33.setTextSize(13);
                        row.addView(tv33);

                        TextView tv44 = new TextView(this);
                        tv44.setText("UNAME");
                        tv44.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv44.setTextColor(Color.BLACK);
                        tv44.setGravity(Gravity.CENTER);
                        tv44.setTextSize(13);
                        tv44.setPadding(10, 15, 10, 15);
                        tv44.setBackgroundResource(R.drawable.item);
                        row.addView(tv44);

                        TextView tv55 = new TextView(this);
                        tv55.setText("RETAIL");
                        tv55.setTextColor(Color.BLACK);
                        tv55.setTextSize(13);
                        tv55.setGravity(Gravity.CENTER);
                        tv55.setPadding(10, 15, 10, 15);
                        tv55.setBackgroundResource(R.drawable.item);
                        row.addView(tv55);

                        TextView tv66 = new TextView(this);
                        tv66.setText("WHOLESALE");
                        tv66.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv66.setTextSize(13);
                        tv66.setTextColor(Color.BLACK);
                        tv66.setGravity(Gravity.CENTER);
                        tv66.setPadding(10, 15, 10, 15);
                        tv66.setBackgroundResource(R.drawable.item);
                        row.addView(tv66);

                        TextView tv67 = new TextView(this);
                        tv67.setText("TRADE");
                        tv67.setTextColor(Color.BLACK);
                        tv67.setTextSize(13);
                        tv67.setGravity(Gravity.CENTER);
                        tv67.setPadding(10, 15, 10, 15);
                        tv67.setBackgroundResource(R.drawable.item);
                        row.addView(tv67);

                        TextView tv68 = new TextView(this);
                        tv68.setText("PERCENTAGE");
                        tv68.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv68.setTextColor(Color.BLACK);
                        tv68.setTextSize(13);
                        tv68.setGravity(Gravity.CENTER);
                        tv68.setPadding(10, 15, 10, 15);
                        tv68.setBackgroundResource(R.drawable.item);
                        row.addView(tv68);


                        TextView tv69 = new TextView(this);
                        tv69.setText("TAX");
                        tv69.setTextColor(Color.BLACK);
                        tv69.setTextSize(13);
                        tv69.setGravity(Gravity.CENTER);
                        tv69.setPadding(10, 15, 10, 15);
                        tv69.setBackgroundResource(R.drawable.item);
                        row.addView(tv69);


                        TextView tv70 = new TextView(this);
                        tv70.setText("SUBCATEGARY");
                        tv70.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv70.setTextColor(Color.BLACK);
                        tv70.setTextSize(13);
                        tv70.setGravity(Gravity.CENTER);
                        tv70.setPadding(10, 15, 10, 15);
                        tv70.setBackgroundResource(R.drawable.item);
                        row.addView(tv70);

                        TextView tv71 = new TextView(this);
                        tv71.setText("CATEGARY");
                        tv71.setTextColor(Color.BLACK);
                        tv71.setTextSize(13);
                        tv71.setGravity(Gravity.CENTER);
                        tv71.setPadding(10, 15, 10, 15);
                        tv71.setBackgroundResource(R.drawable.item);
                        row.addView(tv71);

                        TextView tv72 = new TextView(this);
                        tv72.setText("COMPANY");
                        tv72.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv72.setTextColor(Color.BLACK);
                        tv72.setTextSize(13);
                        tv72.setGravity(Gravity.CENTER);
                        tv72.setPadding(10, 15, 10, 15);
                        tv72.setBackgroundResource(R.drawable.item);
                        row.addView(tv72);


                        TextView tv73 = new TextView(this);
                        tv73.setText("TYPE");
                        tv73.setTextColor(Color.BLACK);
                        tv73.setTextSize(13);
                        tv73.setGravity(Gravity.CENTER);
                        tv73.setPadding(10, 15, 10, 15);
                        tv73.setBackgroundResource(R.drawable.item);
                        row.addView(tv73);


                        TextView tv74 = new TextView(this);
                        tv74.setText("PACKSIZE");
                        tv74.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv74.setTextColor(Color.BLACK);
                        tv74.setTextSize(13);
                        tv74.setGravity(Gravity.CENTER);
                        tv74.setPadding(10, 15, 10, 15);
                        tv74.setBackgroundResource(R.drawable.item);
                        row.addView(tv74);

                        TextView tv75 = new TextView(this);
                        tv75.setText("WEIGHT");
                        tv75.setTextColor(Color.BLACK);
                        tv75.setTextSize(13);
                        tv75.setGravity(Gravity.CENTER);
                        tv75.setPadding(10, 15, 10, 15);
                        tv75.setBackgroundResource(R.drawable.item);
                        row.addView(tv75);

                        TextView tv76 = new TextView(this);
                        tv76.setText("WEIGHTUNIT");
                        tv76.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv76.setTextColor(Color.BLACK);
                        tv76.setTextSize(13);
                        tv76.setGravity(Gravity.CENTER);
                        tv76.setPadding(10, 15, 10, 15);
                        tv76.setBackgroundResource(R.drawable.item);
                        row.addView(tv76);

                        TextView tv77 = new TextView(this);
                        tv77.setText("CURRENTSTOCK");
                        tv77.setTextColor(Color.BLACK);
                        tv77.setTextSize(13);
                        tv77.setGravity(Gravity.CENTER);
                        tv77.setPadding(10, 15, 10, 15);
                        tv77.setBackgroundResource(R.drawable.item);
                        row.addView(tv77);
                        t1.addView(row);
                        t++;

                    }
                    if (t!=0) {

                        String a = cn.getORDERCODE();
                        String f1 = cn.getBARCODE();
                        TableRow  row1= new TableRow(this);
                        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                        row1.setLayoutParams(lp);

                        TextView t001= new TextView(this);
                        t001.setText(a.toString());
                        t001.setTextColor(Color.BLACK);
                        t001.setGravity(Gravity.CENTER);
                        t001.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        t001.setBackgroundResource(R.drawable.item);
                        t001.setPadding(10, 15, 10, 15);
                        t001.setTextSize(13);
                        row1.addView(t001);

                        TextView tv1 = new TextView(this);
                        tv1.setText(f1.toString());
                        tv1.setTextColor(Color.BLACK);
                        tv1.setGravity(Gravity.CENTER);
                        tv1.setBackgroundResource(R.drawable.item);
                        tv1.setPadding(10, 15, 10, 15);
                        tv1.setTextSize(13);
                        row1.addView(tv1);

                        TextView tv2 = new TextView(this);
                        tv2.setText(cn.getNAME());
                        tv2.setTextColor(Color.BLACK);
                        tv2.setGravity(Gravity.CENTER);
                        tv2.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv2.setBackgroundResource(R.drawable.item);
                        tv2.setPadding(10, 15, 10, 15);
                        tv2.setTextSize(13);
                        row1.addView(tv2);

                        TextView tv3 = new TextView(this);
                        tv3.setText(cn.getSIZE());
                        tv3.setTextColor(Color.BLACK);
                        tv3.setGravity(Gravity.CENTER);
                        tv3.setBackgroundResource(R.drawable.item);
                        tv3.setPadding(10, 15, 10, 15);
                        tv3.setTextSize(13);
                        row1.addView(tv3);

                        TextView tv4 = new TextView(this);
                        tv4.setText(cn.getUNAME());
                        tv4.setTextColor(Color.BLACK);
                        tv4.setGravity(Gravity.CENTER);
                        tv4.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv4.setBackgroundResource(R.drawable.item);
                        tv4.setPadding(10, 15, 10, 15);
                        tv4.setTextSize(13);
                        row1.addView(tv4);

                        TextView tv5 = new TextView(this);
                        tv5.setText(cn.getRETAIL());
                        tv5.setTextColor(Color.BLACK);
                        tv5.setGravity(Gravity.CENTER);
                        tv5.setBackgroundResource(R.drawable.item);
                        tv5.setPadding(10, 15, 10, 15);
                        tv5.setTextSize(13);
                        row1.addView(tv5);

                        TextView tv7 = new TextView(this);
                        tv7.setText(cn.getWHOLESALE());
                        tv7.setTextColor(Color.BLACK);
                        tv7.setGravity(Gravity.CENTER);
                        tv7.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv7.setBackgroundResource(R.drawable.item);
                        tv7.setPadding(10, 15, 10, 15);
                        tv7.setTextSize(13);
                        row1.addView(tv7);


                        TextView tv8 = new TextView(this);
                        tv8.setText(cn.getTRADE());
                        tv8.setTextColor(Color.BLACK);
                        tv8.setGravity(Gravity.CENTER);
                        tv8.setBackgroundResource(R.drawable.item);
                        tv8.setPadding(10, 15, 10, 15);
                        tv8.setTextSize(13);
                        row1.addView(tv8);

                        TextView tv9 = new TextView(this);
                        tv9.setText(cn.getPERCENTAGE());
                        tv9.setTextColor(Color.BLACK);
                        tv9.setGravity(Gravity.CENTER);
                        tv9.setBackgroundResource(R.drawable.item);
                        tv9.setPadding(10, 15, 10, 15);
                        tv9.setTextSize(13);
                        row1.addView(tv9);

                        TextView tv10 = new TextView(this);
                        tv10.setText(cn.getTAX());
                        tv10.setTextColor(Color.BLACK);
                        tv10.setGravity(Gravity.CENTER);
                        tv10.setBackgroundResource(R.drawable.item);
                        tv10.setPadding(10, 15, 10, 15);
                        tv10.setTextSize(13);
                        row1.addView(tv10);

                        TextView tv11 = new TextView(this);
                        tv11.setText(cn.getSUBCATAGARY());
                        tv11.setTextColor(Color.BLACK);
                        tv11.setGravity(Gravity.CENTER);
                        tv11.setBackgroundResource(R.drawable.item);
                        tv11.setPadding(10, 15, 10, 15);
                        tv11.setTextSize(13);
                        row1.addView(tv11);

                        TextView tv12 = new TextView(this);
                        tv12.setText(cn.getCATEGARY());
                        tv12.setTextColor(Color.BLACK);
                        tv12.setGravity(Gravity.CENTER);
                        tv12.setBackgroundResource(R.drawable.item);
                        tv12.setPadding(10, 15, 10, 15);
                        tv12.setTextSize(13);
                        row1.addView(tv12);

                        TextView tv13 = new TextView(this);
                        tv13.setText(cn.getCOMPANY());
                        tv13.setTextColor(Color.BLACK);
                        tv13.setGravity(Gravity.CENTER);
                        tv13.setBackgroundResource(R.drawable.item);

                        tv13.setPadding(10, 15, 10, 15);
                        tv13.setTextSize(13);
                        row1.addView(tv13);

                        TextView tv14 = new TextView(this);
                        tv14.setText(cn.getTYPE());
                        tv14.setTextColor(Color.BLACK);
                        tv14.setGravity(Gravity.CENTER);
                        tv14.setBackgroundResource(R.drawable.item);
                        tv14.setPadding(10, 15, 10, 15);
                        tv14.setTextSize(13);
                        row1.addView(tv14);

                        TextView tv16 = new TextView(this);
                        tv16.setText(cn.getPACKSIZE());
                        tv16.setTextColor(Color.BLACK);
                        tv16.setGravity(Gravity.CENTER);
                        tv16.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv16.setBackgroundResource(R.drawable.item);
                        tv16.setPadding(5, 15, 5, 15);
                        tv16.setTextSize(13);
                        row1.addView(tv16);

                        TextView tv17 = new TextView(this);
                        tv17.setText(cn.getWEIGHT());
                        tv17.setTextColor(Color.BLACK);
                        tv17.setGravity(Gravity.CENTER);
                        tv17.setBackgroundResource(R.drawable.item);
                        tv17.setPadding(5, 15, 5, 15);
                        tv17.setTextSize(13);
                        row1.addView(tv17);

                        TextView tv18 = new TextView(this);
                        tv18.setText(cn.getWEIGHTUNIT());
                        tv18.setTextColor(Color.BLACK);
                        tv18.setGravity(Gravity.CENTER);
                        tv18.setBackgroundColor(Color.parseColor("#f8f8f8"));
                        tv18.setBackgroundResource(R.drawable.item);
                        tv18.setPadding(5, 15, 5, 15);
                        tv18.setTextSize(13);
                        row1.addView(tv18);

                        TextView tv19 = new TextView(this);
                        tv19.setText(cn.getCURRENTSTOCK());
                        tv19.setTextColor(Color.BLACK);
                        tv19.setGravity(Gravity.CENTER);
                        tv19.setBackgroundResource(R.drawable.item);
                        tv19.setPadding(5, 15, 5, 15);
                        tv19.setTextSize(13);
                        row1.addView(tv19);


                        t1.addView(row1);

                    }}t=0;

            }
            catch (Exception e){
                //t2.setText(e.toString());
            }

        }
        else{
            // t2.setText("DataBase is not Readable");
        }

    }
}