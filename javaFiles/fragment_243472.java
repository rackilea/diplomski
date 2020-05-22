TableLayout table = (TableLayout) findViewById(R.id.TableLayout01);
            for (int r=1; r<=rowCount; r++){
                TableRow tr = new TableRow(this);
                for (int c=1; c<=columnCount; c++){
                    ImageView im = new ImageView (this);
                    im.setImageDrawable(getResources().getDrawable(R.drawable.image_name));
                    im.setPadding(0, 0, 0, 0); //padding in each image if needed
                    //add here on click event etc for each image...
                    //...
                    tr.addView(im, imageWidth,imageHeight); 
                }
                table.addView(tr);
            }