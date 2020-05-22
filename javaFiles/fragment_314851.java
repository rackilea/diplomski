if (e.getSource() == suivant) {
    truesList = new ArrayList<>(); // !!  ADDED *****
    String prompt = questionField.getText();
    prompts.add(prompt);
    ExamPanel.this.setVisible(false);
    ExamFrame.this.setContentPane(new ExamPanel());
    for (int i = 0; i < 2; i++) { // 2 == Number of choices
        choicesList.add(respnsesFields.get(i).getText());
    }
    for (int i = 0; i < 2; i++) {
        if (jCheckBoxes.get(i).isSelected()) {
            truesList.add(respnsesFields.get(i).getText());
        }
    }
    truesMap.put(count, truesList);
    // !! truesList.clear();  // !! REMOVED ****
    count++;
}