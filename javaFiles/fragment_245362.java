public Cursor runQuery(CharSequence constraint) {
    try{
        return fetchDataByName(constraint.toString());
    }catch (SQLException e){
        e.printStackTrace();
    }
    return null;
}