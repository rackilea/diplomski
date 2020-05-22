String[] typefaceArr = new String[] {"fonts/font (1).ttf", "fonts/font (2).ttf",     
"fonts/font (3).ttf", "fonts/font (4).ttf", "fonts/font (5).ttf", "fonts/font (6).ttf",    
"fonts/font (7).ttf", "fonts/font (8).ttf", "fonts/font (9).ttf", "fonts/font (10).ttf",     
"fonts/font (10).ttf"};

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;

        //View row = null;

        if (v == null) {
            LayoutInflater inflater = Main.this.getLayoutInflater();
             v = inflater.inflate(R.layout.genre_list, parent, false);
             TextView item = (TextView)v.findViewById(R.id.txtListText);
             /*switch(position) {
             case 0:
                  tf = Typeface.createFromAsset(getAssets(),"fonts/font (1).ttf");item.setTypeface(tf);
                  break;
             case 1:
                  tf = Typeface.createFromAsset(getAssets(),"fonts/font (2).ttf"); item.setTypeface(tf);
                 break;
             case 2:
                  tf = Typeface.createFromAsset(getAssets(),"fonts/font (3).ttf"); item.setTypeface(tf);
                 break;
             case 3:
                  tf = Typeface.createFromAsset(getAssets(),"fonts/font (4).ttf"); item.setTypeface(tf);
                 break;
             case 4:
                  tf = Typeface.createFromAsset(getAssets(),"fonts/font (5).ttf"); item.setTypeface(tf);
                 break;
             case 5:
                  tf = Typeface.createFromAsset(getAssets(),"fonts/font (6).ttf"); item.setTypeface(tf);
                 break;
             case 6:
                  tf = Typeface.createFromAsset(getAssets(),"fonts/font (7).ttf"); item.setTypeface(tf);
                 break;
             case 7:
                  tf = Typeface.createFromAsset(getAssets(),"fonts/font (8).ttf"); item.setTypeface(tf);
                 break;
             case 8:
                  tf = Typeface.createFromAsset(getAssets(),"fonts/font (9).ttf"); item.setTypeface(tf);
                 break;
             case 9:
                  tf = Typeface.createFromAsset(getAssets(),"fonts/font (10).ttf"); item.setTypeface(tf);
                 break;
             default:
                 tf = Typeface.createFromAsset(getAssets(),"fonts/font (10).ttf"); item.setTypeface(tf);
         }*/
        }

        TextView item = (TextView)v.findViewById(R.id.txtListText);
        item.setText(Genres[position]);
        tf = Typeface.createFromAsset(getAssets(),typefaceArr[position]);
        item.setTypeface(tf);
        // Declare and define the TextView, "icon." This is where
        // the icon in each row will appear.


        return v;
    }