/**
     * The method returns the current Path information as List<String>.
     * <ol>
     * <li>0 - Project name</li>
     * <li>1 - SRC Folder name</li>
     * <li>2 - Package name</li>
     * </ol>
     *
     * @return List<Object>
     */
    public static List<Object> getSelectedObjectPath() {
        // the current selection in the entire page
        final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        final IStructuredSelection selection = (IStructuredSelection) window.getSelectionService().getSelection("org.eclipse.jdt.ui.PackageExplorer");
        final Object o = selection.getFirstElement();
        final List<Object> a = new ArrayList<Object>(4);
        IJavaElement obj = (IJavaElement) o;
        if (o == null) {
            return null;
        }
        while (obj != null) {
            a.add(0, obj);
            obj = obj.getParent();
        }
        // remove JavaModel
        a.remove(0);
        return a;
    }