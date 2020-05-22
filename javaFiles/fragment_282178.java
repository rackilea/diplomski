public void refresh() {
    try {
        mTreeViewer.getControl().setRedraw(false);
        mTreeViewer.refresh(true);
        mTreeViewer.expandAll();
    }
    finally {
        mTreeViewer.getControl().setRedraw(true);
    }
}