Observable[] progressProps = new Observable[tasks.size()];

for (int i = 0 ; i < tasks.size(); i++) {
    progressProps[i]=tasks.get(i).progressProperty();
}

DoubleBinding totalProgress = Bindings.createDoubleBinding(new Callable<Double>() {
    @Override
    public Double call() {
        double total = 0 ;
        for (Task task : tasks) {
            total = total + task.getProgress();
        }
        return total / tasks.size();
    }
}, progressProps);
bar.progressProperty().bind(totalProgress);


for (final Task t : tasks) {
    threadPool.submit(t);
    t.setOnSucceeded(handler);
}