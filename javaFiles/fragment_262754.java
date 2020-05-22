@Override
public void run() {
    ApiData data = new ApiData();
    data.title = Arrays.copyOf(product.getTitle(), product.getTitle().length);
    ...

    arrayListData.add(data);