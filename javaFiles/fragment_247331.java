TreeViewer viewer = new TreeViewer(tree);
viewer.addSelectionChangedListener(new ISelectionChangedListener() {
    @Override
    public void selectionChanged(SelectionChangedEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        System.out.println("Clicked Item>>" + selection.getFirstElement());
    }
});