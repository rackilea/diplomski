void getDirSize(File dir,depth) {
    long size = 0;

    if (dir.isFile()) {
        size = dir.length();
    } else {
        depth++;
        File[] subFiles = dir.listFiles();

        for (File file : subFiles) {
            if (file.isFile()) {
                size += file.length();
            } else {
                size += this.getDirSize(file,depth);
                if(depth==1) {
                System.out.println("Directory " + file.getName()
                        + " size = " + size / 1021 / 1024);
}
            }

        }
    }

}