public String getSingular_Value_InTransaction(String query){
    //Declaration of variables
    Cursor a1 = null;

    try{
        a1 = database.rawQuery(query,null);
        a1.moveToFirst();

        if(a1.getString(0) != null){
            String result = a1.getString(0);
            a1.close();
            return result;
        }
        else{
            a1.close();
            return "";
        }
    }
    catch (NullPointerException ex){
        return "";
    }
    catch (CursorIndexOutOfBoundsException ex){
        return "";
    }
    catch (Exception ex){
        Log.e("-- BDD.execute_SelectCommand --","Exception", ex);
        return "";
    }
}