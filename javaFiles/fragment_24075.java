try{
                //Class<drawable> res = R.drawable.class;
                //Field field = res.getField(theHotel.getImage().substring(10, theHotel.getImage().length()));              
                //drawableId = field.getInt(null);

                drawableId=getResources().getIdentifier(theHotel.getImage().substring(1, theHotel.getImage().length()), null, getPackageName());
                Drawable theImage=getResources().getDrawable(drawableId);
                img.setImageDrawable(theImage);
            }