@Override
public void loadChildren(CustomTreeNode tn) {
    ctn = tn;
    LoadChildrenWorker worker = new LoadChildrenWorker();
    worker.execute();
}


private class LoadChildrenWorker extends SwingWorker<String, Object> {

            @Override
    protected String doInBackground() throws Exception {
                    //load source here and return a string when finished.
                    //In my case its a string repesentation of a directory
    }

    @Override
    protected void done() {
            //with get(), you get the string from doBackground()
            for (String str : parseFromOutput(get())) {
                    if (str.endsWith("/")) {
                        ctn.add(new CustomTreeNode("Directory");
                    } else {
                        ctn.add(new CustomTreeNode("Leaf");
                    }
            }
            //call listeners
            ctn.fireChildrenLoaded();
    }