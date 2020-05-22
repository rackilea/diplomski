Map<Object, List<Object>> mapOfCheckedElements = new HashMap<Object, List<Object>>();
    for (TreeItem level1 : checkBoxTreeViewer.getTree().getItems()) {
        if (level1.getChecked()) {
            List<Object> checkedChildren = new ArrayList<Object>();
            for (TreeItem level2 : level1.getItems()) {
                if (level2.getChecked()) {
                    checkedChildren.add(level2);
                }
            }
            mapOfCheckedElements.put(level1, checkedChildren);
        }
    }