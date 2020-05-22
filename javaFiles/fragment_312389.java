@PostMapping(path="/check/keywords", consumes="application/json", produces="application/json")
public int totalKeywords(@RequestBody Data data) {
    String text = data.getText();
    String[] keywords = data.getKeywords();
    // do whatever...
    return ...
}