comboBox.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        Object selected = comboBox.getSelectedItem();
        if (selected.toString().equals("Afficher les questions faciles")) {
            questions = GestionQuestionDelegate.doFindAllQuestionsByNiveauDeDifficulte("Facile");
            System.out.println(comboBox.getSelectedItem());
        } else if (selected.toString().equals("Afficher les questions moyens")) {
            System.out.println(comboBox.getSelectedItem());
            questions = GestionQuestionDelegate.doFindAllQuestionsByNiveauDeDifficulte("Moyen");
        } else if (selected.toString().equals("Afficher les questions difficiles")) {
            System.out.println(comboBox.getSelectedItem());
            questions = GestionQuestionDelegate.doFindAllQuestionsByNiveauDeDifficulte("Difficile");
        }
        QuestionTableModel model = new QuestionTableModel(questions);
        table.setModel(model);
    }
});