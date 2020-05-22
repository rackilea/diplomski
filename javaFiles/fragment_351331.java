private Options createOptionsChart() {
    Options options = Options.create();
    options.set("isStacked", true);
    //set some options

    Options series_options = Options.create();
    series1_options = Options.create();
    series1_options.set("color","black");
    series_options.set("0",series1_options);
    options.set("series",series_options);
    return options;
}