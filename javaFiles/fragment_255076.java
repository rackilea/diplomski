public String getTANames() {
    String list = "";
    for(int i = 0; i < TAList.length; i++){
        list += TAList[i].first + " " + TAList[i].second + ", ";
    }
    return list;
}