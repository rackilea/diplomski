public SelectModel getMySelectModel() {
    final List<OptionModel> options = new ArrayList<OptionModel>();
    options.add(new CustomOptionModel("First", 1, "First Item"));
    options.add(new CustomOptionModel("Second", 2, "Second Item"));
    options.add(new CustomOptionModel("Third", 3, "Third Item"));
    return new SelectModelImpl(null, options);
}