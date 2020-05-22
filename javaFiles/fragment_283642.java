public class SingleListItem extends Activity{
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
Intent i = getIntent();

// getting attached intent data
String product = i.getStringExtra("title");
String ldesc = i.getStringExtra("longdesc");
String lpreview = i.getStringExtra("preview");
this.setContentView(R.layout.details_list);

TextView txtProduct = (TextView) findViewById(R.id.name);
TextView txtLdesc = (TextView) findViewById(R.id.longdesc);
SmartImageView imgPreview = (SmartImageView) findViewById(R.id.preview);

imgPreview.setImageUrl(lpreview);


// displaying selected product name
txtProduct.setText(product);
txtLdesc.setText(ldesc);