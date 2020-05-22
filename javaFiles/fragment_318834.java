BufferedReader reader = new BufferedReader(new FileReader(sDataPath));
try {
    ...
} finally {
    reader.close();
}