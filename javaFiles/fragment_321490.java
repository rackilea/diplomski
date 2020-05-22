private ComboChart.Options createComboOptions(String title) {
    ComboChart.Options options = ComboChart.createComboOptions();

    Series bars1 = Series.create();
    bars1.setType(Type.BARS);
    options.setSeries(0, bars1);

    Series bars2 = Series.create();
    bars2.setType(Type.BARS);
    options.setSeries(1, bars2);

    Series line = Series.create();
    line.setType(Type.LINE);
    options.setSeries(2, line);

    options.setIsStacked(true);
    return options;
}