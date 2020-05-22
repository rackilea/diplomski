final JFileChooser diag = new JFileChooser();
diag.setMultiSelectionEnabled(true);

final List<File> chosen = new ArrayList<File>();

diag.addPropertyChangeListener(
                    JFileChooser.SELECTED_FILES_CHANGED_PROPERTY,
                    new PropertyChangeListener() {
    @Override
    public void propertyChange(PropertyChangeEvent e) {

        List<File> selected = Arrays.asList(diag.getSelectedFiles());
        Iterator<File> it = chosen.iterator();

        while (it.hasNext())
            if (!selected.contains(it.next()))
                it.remove();

        for (File file : selected)
            if (!chosen.contains(file))
                chosen.add(file);
    }
});

if (diag.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
    // 'chosen' holds selected files in order of selection