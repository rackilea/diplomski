listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TextView tv = (TextView) view.findViewById(R.id.textViewName);
        String strSelectedString = tv.getText().toString();
        for(int selectedPosition = 0; selectedPosition  < names.lenght; selectedPosition++)
        {
            if(names[selectedPosition].equalsIgnoreCase(strSelectedString))
            {
                moveToNextActivity(selectedPosition);
                break;
            }
        }    

        }
    });

    public void moveToNextActivity(int position)
    {
        if (position == 0) {
            Intent myIntent = new Intent(view.getContext(), akalp.class);
            startActivityForResult(myIntent, 0);
        }

        if (position == 1) {
            Intent myIntent = new Intent(view.getContext(), Sukharta.class);
            startActivityForResult(myIntent, 0);
        }

        if (position == 2) {
            Intent myIntent = new Intent(view.getContext(), gajananashriganraya.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 3) {
            Intent myIntent = new Intent(view.getContext(), yehihovittale.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 4) {
            Intent myIntent = new Intent(view.getContext(), lavathavthi.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 5) {
            Intent myIntent = new Intent(view.getContext(), durgedurgat.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 6) {
            Intent myIntent = new Intent(view.getContext(), nyanraja.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 7) {
            Intent myIntent = new Intent(view.getContext(), bolya.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 8) {
            Intent myIntent = new Intent(view.getContext(), vovalo.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 9) {
            Intent myIntent = new Intent(view.getContext(), mangesha.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 10) {
            Intent myIntent = new Intent(view.getContext(), alaganraya.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 11) {
            Intent myIntent = new Intent(view.getContext(), shendorlal.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 12) {
            Intent myIntent = new Intent(view.getContext(), ekdanta.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 13) {
            Intent myIntent = new Intent(view.getContext(), karpurgaura.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 14) {
            Intent myIntent = new Intent(view.getContext(), heygajavadana.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 15) {
            Intent myIntent = new Intent(view.getContext(), prathmeshvara.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 16) {
            Intent myIntent = new Intent(view.getContext(), sainatha.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 17) {
            Intent myIntent = new Intent(view.getContext(), satyanarayan.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 18) {
            Intent myIntent = new Intent(view.getContext(), jaidevijaidevi.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 19) {
            Intent myIntent = new Intent(view.getContext(),omjaimahalakshmi.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 20) {
            Intent myIntent = new Intent(view.getContext(), maitohaarti.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 21) {
            Intent myIntent = new Intent(view.getContext(), danyadanyaho.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 22) {
            Intent myIntent = new Intent(view.getContext(), sukhartakidukharta.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 23) {
            Intent myIntent = new Intent(view.getContext(), omjaijagdish.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 24) {
            Intent myIntent = new Intent(view.getContext(), heygaurigajanana.class);
            startActivityForResult(myIntent, 0);
        }
        if (position == 25) {
            Intent myIntent = new Intent(view.getContext(), ghalinlotangan.class);
            startActivityForResult(myIntent, 0);
        }
    }