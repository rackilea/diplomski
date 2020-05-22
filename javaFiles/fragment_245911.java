ImageButton spaces = findViewById(R.id.spaceship);
            spaces.setBackgroundColor(Color.TRANSPARENT);
            spaces.setOnClickListener(view -> {


              setAllnotSelected();
                    spaces.setBackgroundColor(Color.DKGRAY);


            });
     ImageButton mask = findViewById(R.id.mask);
            mask.setBackgroundColor(Color.TRANSPARENT);
            mask.setOnClickListener(view -> {

               setAllnotSelected();
                    mask.setBackgroundColor(Color.DKGRAY);


            });

public void setAllnotSelected();
{
mask.setBackgroundColor(Color.TRANSPARENT);
spaces.setBackgroundColor(Color.TRANSPARENT);
}