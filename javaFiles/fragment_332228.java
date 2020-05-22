selection = new HashMap<String, String>();
            selection.put("Text File", ".txt");
            selection.put("Rar File", ".rar");
            selection.put("Zip File", ".rar");
            selection.put("Tar File", ".tar");
            selection.put("Ini File", ".ini");
            fem = new FileExtensionModel(selection);

HashMap<String, FileFilter> fileFilters = new HashMap<String, FileFilter>();

for (String key : selection.keySet()) {
    fileFilters.add(new MyFileFilter(key, selection.get(key)));
}