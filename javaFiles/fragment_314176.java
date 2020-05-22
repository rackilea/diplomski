DefaultMutableTreeNode addNodes(DefaultMutableTreeNode curTop, File dir) {

    File[] tmp = dir.listFiles();
    List<File> ol = new ArrayList<File>(Arrays.asList(tmp));
    Collections.sort(ol, new Comparator<File>() {

        @Override
        public int compare(File o1, File o2) {
            if(o1.isDirectory() && o2.isDirectory()){
                return o1.compareTo(o2);
            } else if(o1.isDirectory()){
                return -1;
            } else if(o2.isDirectory()){
                return 1;
            }
            return o1.compareTo(o2);
        }
    });


    for (int fnum = 0; fnum < ol.size(); fnum++) {

        File file = ol.get(fnum);
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(file);
        if (file.isDirectory()) {
            addNodes(node, file);
        }
        curTop.add(node);
    }

    return curTop;
}