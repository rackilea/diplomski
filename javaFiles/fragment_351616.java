public class Length extends Fragment implements AdapterView.OnItemSelectedListener

    {
        String[] Lunits = {"Inches", "Feet", "Yards", "Miles", "Km", "Meters" ,"Centimeters" };

        EditText mEditText;
        TextView a, b, c, d, e, f, g;
        String mSelectedUnit = "";

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           // return inflater.inflate(R.layout.length_layout,null);


            final View myFragmentView = inflater.inflate(R.layout.length_layout, container, false); //get laength.xml
            Spinner spin = (Spinner)myFragmentView.findViewById(R.id.spinner);
            a=(TextView)myFragmentView.findViewById(R.id.textView9);
            b=(TextView)myFragmentView.findViewById(R.id.textView10);
            c=(TextView)myFragmentView.findViewById(R.id.textView11);
            d=(TextView)myFragmentView.findViewById(R.id.textView12);
            e=(TextView)myFragmentView.findViewById(R.id.textView13);
            f=(TextView)myFragmentView.findViewById(R.id.textView14);
            g=(TextView)myFragmentView.findViewById(R.id.textView15);

            mEditText =(EditText)myFragmentView.findViewById(R.id.editText);


            ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,Lunits);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin.setAdapter(aa);
            spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                     mSelectedUnit = Lunits[position];
                     convertValue();

                }

                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


           mEditText.addTextChangedListener(new TextWatcher() {

              @Override
              public void beforeTextChanged(CharSequence s, int start, int count, int after) {
              }

              @Override
              public void onTextChanged(CharSequence s, int start, int before, int count) {
              }

              @Override
              public void afterTextChanged(Editable s)
              {
                 convertValue();
              }

          });

            return myFragmentView;
        }

        private void convertValue(){
           double ans=0;
           String s = mEditText.getText().toString(); 

           if( !s.toString().equals("") && s.length() > 0 )
           {
              ans = Double.parseDouble(s);
           }

           if(mSelectedUnit.equals("Inches"))
           {
              double inches = ( ans * 1 );
              a.setText(" "+inches);

              double feet = ( ans * 0.0833 );
              b.setText(" "+feet);

              double yards = ( ans * 0.02777778 );
              c.setText(" " + yards);

              double miles = ( ans * (1/63360) );
              d.setText(" " + miles);

              double kilometers = ( (ans/39370) );
              e.setText(" " + kilometers);

              double meters = ( ans * 0.0254 );
              f.setText(" " + meters);

              double centimeters = ( ans * 2.54 );
              g.setText(" "+centimeters);
           }

           if (mSelectedUnit.equals("Feet"))
           {
               double inches = ( ans * 12 );
               a.setText(" "+inches);

               double feet = ( ans * 1 );
               b.setText(" "+feet);

               double yards = ( ans * 0.3333333 );
               c.setText(" " + yards);

               double miles = ( ans * (0.0001893939) );
               d.setText(" " + miles);

               double kilometers = ( ans * 0.0003048 );
               e.setText(" " + kilometers);

               double meters = ( ans * 0.3048 );
               f.setText(" " + meters);

               double centimeters = ( ans * 30.48 );
               g.setText(" "+centimeters);
           }

         }
      }
    }