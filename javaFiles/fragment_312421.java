File directory = new File("C:/XYZ");

final ArrayList<String> innerDigits = new ArrayList<String>();

FileFilter filter = new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        if (!pathname.isFile() || !pathname.getName().endsWith("doc"))
            return false;

        // Extract whatever you need from the file object
        String[] parts = pathname.getName().split("_");
        innerDigits.add(parts[1]);

        return true;
    }
};

// No need to store the results, we extracted the info in the filter method
directory.listFiles(filter);

for (String data : innerDigits)
    System.out.println(data);