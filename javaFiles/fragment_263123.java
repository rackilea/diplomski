public String checkdata(float f) {

        String Picked = ec1.getText().toString();
        Log.i("Color Picked(Hex)",Picked);
        
        String gradSelect = ec1.getText().toString().substring(5);     // picking B from #RRGGBB which is 5th element
        Log.i("Seperated Single(Hex)",gradSelect);
        int intGrad = Integer.parseInt(gradSelect,16);    //Converting Blue to Integer equivalent
        Log.i("Converted to Int", ""+intGrad );

        float float2Grad = f*255/5;    // Mapping Input f's ( 0 to 5 ) values to 0 to 255 color values
       // float float2Grad = (intGrad - f)/ (6-f);     //another formula, but range will not be full 0 to 255 integers of color
        Log.i("Float2Gradient", ""+float2Grad );

        int rounded_i = Math.round(float2Grad);                              //float to int
        Log.i("Rounded Gradient(Int)", ""+rounded_i);

        String updatedBlueHex = Integer.toHexString(rounded_i);              // padding by O for integer values < 15 (Hex 0 to F), so  that RRGGB can be avoided and RRGGBB
        if (updatedBlueHex.length() == 1) {
            updatedBlueHex = "0".concat(updatedBlueHex);                       // if its F then It will give 0F and hence RRGGBB formate maintained
                                }
        Log.i("Updated Single(Hex)",updatedBlueHex);



        String redGreen = Picked.substring(1,5);                                 // RRGG 
        Log.i("Untouched RG(Hex)", redGreen);

        String Returning = redGreen.concat(updatedBlueHex);                                // RRGG + Bb = RRGGBB
        Log.i("Returned String(Hex)",Returning);

        return "#"+Returning; 

    }