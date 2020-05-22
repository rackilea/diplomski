for (int arr_size=0;arr_size<biblebookLength;arr_size++){

    JSONObject bibleList= (JSONObject) jObject.get(arr_size);
    bnumber = bibleList.getString("-bnumber");
    bname = bibleList.getString("-bname");

    jsbnumber.SavePreferences("jsbnumber", bnumber);
    jsbname.SavePreferences("jsbname", bname);

     // get CHAPTER JSONArray
      JSONArray arr_chapter=bibleList.getJSONArray("CHAPTER");

       for (int i=0;i<arr_chapter.length();i++){
        JSONObject jsonobj_chapter= arr_chapter.get(i);

            // get -cnumber from CHAPTER object
             String str_cnumber=jsonobj_chapter.getString("-cnumber");

             // get VERS JSONArray from CHAPTER JSON object


              JSONArray arr_vers=jsonobj_chapter.getJSONArray("VERS");

               for (int j=0;j<arr_vers.length();j++){
               JSONObject jsonobj_vers= arr_vers.get(j);

                // get -vnumber from CHAPTER object
                String str_vnumber=jsonobj_chapter.getString("-vnumber");
                // get #text from CHAPTER object
                String str_text=jsonobj_chapter.getString("#text");

          } 
        }

 }