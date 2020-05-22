try {
        File dir = context.getCacheDir();
        if (dir != null && dir.isDirectory()) {
            deleteDir(dir);

        }
    } catch (Exception e) {
        e.printStackTrace();
    }