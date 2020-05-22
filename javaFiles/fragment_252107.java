this.btnBrowseFile.addListener(SWT.Selection, event -> {
        final Shell shell = this.getShell();
        final FileDialog dialog = new FileDialog(shell, SWT.OPEN);
        dialog.setText("Select valid text file");
        dialog.setFilterExtensions("*.txt");
        String selectedFileStr = dialog.open();
        if (selectedFileStr != null && !selectedFileStr.isEmpty()) {
            final Stream<String> lines = Files.lines(Paths.get(selectedFileStr), StandardCharsets.UTF_8);
            List<String> readList = lines.collect(Collectors.toList());
            lines.close();
            readList.forEach(line -> {
                System.out.println(line);
                // Do your work
            });
        }
    });