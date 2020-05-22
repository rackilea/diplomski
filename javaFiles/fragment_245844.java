public static List<DataFile> someMethod(List<DataFile> dataFiles) {
    Predicate<String> hasCompanyAndDate = companyAndDateFilter(date, BLABLA, LALALA);

    return dataFiles.stream()
        .filter(dataFile -> hasCompanyAndDate.test(dataFile.getFileName()))
        .collect(Collectors.toList());
}