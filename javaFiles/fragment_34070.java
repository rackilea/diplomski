private static List<File> recursiveSearch(File dir) {
    File[] files = dir.listFiles();
    List<File> result = new ArrayList<File>();
    if (files != null) {
        for (File file : files)
            if (file.isDirectory()) {
                result.add(file);
                List<File> tempList = recursiveSearch(file);

                for (File temp : tempList)
                    result.add(temp);
            } else {
                result.add(file);
                System.out.println(file.getPath());
            }
    }

    return result;
}