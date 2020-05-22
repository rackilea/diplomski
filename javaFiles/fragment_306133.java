public ArrayList<ArticleData> getObjects(){
    if (db.getSession().isSessionValid()){
        List<ArticleData> allData = db.getObjects();
        data = new ArrayList<>();

        for (ArticleData articleData : allData) {
            if(articleData.equals(currentDate)){
                data.add(articleData);
            }
        }
        return data;
    }else{
        return null;
    }
}