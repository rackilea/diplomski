// Before using the function, I'm sure that:
// paragraph.getText().contains(surroundedTag) == true
private void editParagraphWithData(XWPFParagraph paragraph, String surroundedTag, String replacement) {
    List<Integer> runsToRemove = new LinkedList<Integer>();
    StringBuilder tmpText = new StringBuilder();
    int runCursor = 0;

    // Processing (in normal order) the all runs until I found my surroundedTag
    while (!tmpText.toString().contains(surroundedTag)) {
        tmpText.append(paragraph.getRuns().get(runCursor).text());
        runsToRemove.add(runCursor);
        runCursor++;
    }

    tmpText = new StringBuilder();
    // Processing back (in reverse order) to only keep the runs I need to edit/remove
    while (!tmpText.toString().contains(surroundedTag)) {
        runCursor--;
        tmpText.insert(0, paragraph.getRuns().get(runCursor).text());
    }

    // Edit the first run of the tag
    XWPFRun runToEdit = paragraph.getRuns().get(runCursor);
    runToEdit.setText(tmpText.toString().replaceAll(surroundedTag, replacement), 0);

    // Forget the runs I don't to remove
    while (runCursor >= 0) {
        runsToRemove.remove(0);
        runCursor--;
    }

    // Remove the unused runs
    Collections.reverse(runsToRemove);
    for (Integer runToRemove : runsToRemove) {
        paragraph.removeRun(runToRemove);
    }
}