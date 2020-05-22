public void setId(String id) {
    if (Integer.parseInt(id) < 1){
        throw new IllegalArgumentException("id must be greater than zero:" id);
    }
    this.id = id;
}