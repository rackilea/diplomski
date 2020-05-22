// first, submit all tasks, assuming "threadmaker" is an ExecutorService
List<Future<List<TagInfo>>> futures=threadmaker.invokeAll(
    active_sites.stream()
        .map(site -> new TAG_SCANNER(site, loggr))
        .collect(Collectors.toList())
);
// now fetch all results
for(Future<List<TagInfo>> result: futures) {
    //SOUND THE ALARMS
    try {
        alarm_tags.addAll(result.get());
    } catch (InterruptedException | ExecutionException e) {
        // not a recommended way of handling
        // but I keep your code here for simplicity
        e.printStackTrace();
    }
}