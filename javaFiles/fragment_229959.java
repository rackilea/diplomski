public void setData(MaterialData data) {
    Material mat = getType();

    if (data == null || mat == null || mat.getData() == null) {
        this.data = data;
    } else {
        if ((data.getClass() == mat.getData()) || (data.getClass() == MaterialData.class)) {
            this.data = data;
        } else {
            throw new IllegalArgumentException("Provided data is not of type " + mat.getData().getName() + ", found " + data.getClass().getName());
        }
    }
}