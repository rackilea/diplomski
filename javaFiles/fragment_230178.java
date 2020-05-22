public static void main(String args[]) throws Exception {
        final String FILE_PATH = "d:\\test.txt";
        FileUtils.deleteQuietly(new File(FILE_PATH));
        FileWriter fileWriter = new FileWriter(FILE_PATH, false);
        fileWriter.append(new Date().toString());
        fileWriter.close();
        setFileCreationTime(FILE_PATH);

    }

    public static void setFileCreationTime(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        FileTime fileTime = FileTime.fromMillis(System.currentTimeMillis());
        /* Changing the Created Time Stamp */
        Files.setAttribute(path, "basic:creationTime", fileTime,
                LinkOption.NOFOLLOW_LINKS);
    }