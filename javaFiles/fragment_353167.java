List<Runnable> jobs = new ArrayList<Runnable>();

jobs.add(new Runnable() {
    public void run() {
        CSVWriter.createFileOfCompany("Random Company");
    }
});

jobs.add(new Runnable() {
    public void run() {
        FileConverter.convertCSVToXLS(classPath + "/Output/Random_Company.csv");
    }
});

for (Runnable job : jobs) {
    job.run();
}