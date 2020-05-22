public class savev extends Activity implements OnClickListener{
        TextView txtDesc;
ViewGroup mainContainer; //Linearlayout with textviews
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.country);
            txtDesc=(TextView) findViewById(R.id.textview4);
            mainContainer = (ViewGroup) findViewId(R.id.mainLayout);
            txtDesc.setVisibility(View.GONE);
            findViewById(R.id.textview1).setOnClickListener(this);
            findViewById(R.id.textview2).setOnClickListener(this);
            findViewById(R.id.textview3).setOnClickListener(this);
        }




         @Override
         public void onClick(View v) 
         {
              switch (v.getId())
              {
              case R.id.textview1:
                 txtDesc.setText(getString(R.string.country1Meaning));                  
              break;
              case R.id.textview2:
                  txtDesc.setText(getString(R.string.country2Meaning)); 
              break;
              case R.id.textview3:
                  txtDesc.setText(getString(R.string.country3Meaning)); 
              break;

              default:break;
              }
              mainContainer.removeView (txtDesc)
              int pos = mainContainer.indexOfChild(v);
              if(pos>0) {
                   txtDesc.setVisibility(VISIBLE);
                   if(pos == getChildCount)
                   mainContainer.addView(txtDesc);
                   else 
                    mainContainer.addView(txtDesc,pos+1);
              }

         }
    }