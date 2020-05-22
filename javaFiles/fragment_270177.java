private String findDataFolder(File folder) {
    if (folder != null) {
        if (folder.listFiles() != null) {
            for (File file : folder.listFiles()) {
                if (file.isFile()) {
                    if (file.getParent().contains(
                            DATA_DIRECTORY)) {
                        System.out.println("is this happening");
                        String result = file.getParent();
                        return result;
                    }
                } else {
                    String result = findDataFolder(file);
                    if(!result.equals("hi"))
                        return result;
                }
            }
        }
    }
    return "hi";
}