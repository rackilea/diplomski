public String getFileHeader() {
    if (alreadyContainsHeader()) {
        return "";
    } else {
        return header;
    }
}

private boolean alreadyContainsHeader() {
    try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.contains(header)) {
                return true;
            } else {
                break;
            }
        }
    } catch (Exception ex) {
        ex.printStackTrace(System.err);
    }
    return false;
}