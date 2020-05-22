String[] Acolorid = new String[color_array.size()];
    for(int i = 0; i < color_array.size(); i++){
        // get the saved data
        Object data = color_array.get(i).getTag();
        if (data != null) {
            Acolorid[i] = data.toString();
        }
    }
    Hcolorid=String.join(",",Acolorid);