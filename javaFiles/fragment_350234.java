/**
 * Creates a json of all files and directories within the given file
 * @param file the root directory to list
 * @return true if success, else false
 */
public static boolean getStructure(Context context, File file) {

    boolean result = false;

    JsonWriter writer;
    try {
        writer = new JsonWriter(new FileWriter(new File(context.getApplicationContext().getExternalFilesDir(null), "FileStructure.json")));
        writer.setIndent("    ");
    } catch (Exception e) {
        Log.e(TAG, e.toString());
        return result;
    }

    try {
        if(file.exists()) {
            result = writeRootDir(writer, file);
        } else {
            result = false;
        }

        writer.close();
    } catch (Exception e) {
        Log.e(TAG, e.toString());
        return result;
    }

    return true;
}

/**
 * writing root directory array and object
 * @param writer the JsonWriter
 * @param dir the root dir
 * @return true if success, else false
 */
private static boolean writeRootDir(JsonWriter writer, File dir) {
    boolean result = false;

    if(!dir.exists() || !dir.isDirectory()) {
        return result;
    }

    try {
        writer.beginArray();
        writer.beginObject();

        writer.name(dir.getPath());
        result = writeDirectory(writer, dir);

        writer.endObject();
        writer.endArray();
    } catch (Exception e) {
        Log.e(TAG, e.toString());
        return result;
    }

    return result;
}


/**
 * for each directory and file within the root directory
 * @param writer the JsonWriter
 * @param dir sub-directory
 * @return true if success, else false
 */
private static boolean writeDirectory(JsonWriter writer, File dir) {
    if(!dir.exists() || !dir.isDirectory()) {
        return false;
    }

    File[] allFiles = dir.listFiles();
    List<File> directories = new ArrayList<>();
    List<File> files = new ArrayList<>();

    for (File subFile : allFiles) {
        if(!subFile.getName().startsWith(".") && !subFile.getName().startsWith("_") && subFile.isDirectory()) {
            directories.add(subFile);
        }
    }

    for(File subFile : allFiles) {
        if(!subFile.getName().startsWith(".") && !subFile.getName().startsWith("_") && !subFile.isDirectory()) {
            files.add(subFile);
        }
    }

    Collections.sort(directories);
    Collections.sort(files);

    try {
        writer.beginArray();
        writer.beginObject();

        if(directories.size() > 0) {
            for(File file : directories) {
                writer.name(file.getName());
                writeDirectory(writer, file);
            }
        }

        writer.endObject();

        if(files.size() > 0) {
            for(File file : files) {
                writer.value(file.getName());
            }
        }

        writer.endArray();
    } catch (Exception e) {
        Log.e(TAG, e.toString());
        return false;
    }

    return true;
}