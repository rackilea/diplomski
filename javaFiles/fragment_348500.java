public void refreshData(String[] deviceName, String[] ip, Integer[] imgid){
    this.deviceName = deviceName;
    this.ip = ip;
    this.imgid = imgid;
    notifyDataSetChanged();
}