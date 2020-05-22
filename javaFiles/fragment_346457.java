public void updateFileList() {
        List<File> files = this.getFilesList();
        Iterator<File> iter = files.iterator();
        while (iter.hasNext()) {
            File f = iter.next();
            if (/*Deletion criteria satisfied*/)
            {
                f.delete();
                iter.remove();
                this.occupiedSize = this.occupiedSize - f.length()/1048576.0;
            }
        }
    }