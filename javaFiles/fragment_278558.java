for (Entry<Data, List<Value>> it : result.entrySet()) {

            TreeItem treeEl= new TreeItem();

            String key = String.valueOf(it.getKey().getName());
            List<Value> list = it.getValue();
            treeEl.setText(key);

            for (Value v: list) {

                TreeItem subTreeEl = new TreeItem();
                subTreeEl.setText(v.getName());
                treeEl.addItem(subTreeEl);

            }

            treeEl.setState(true, true);
            tree.addItem(treeEl);
}