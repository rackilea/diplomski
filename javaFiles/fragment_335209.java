public void setData(List<CellPhone> data) {
        this.data = data;
        refreshData();
}

private void refreshData(){
        this.notifyDataSetChanged();
}