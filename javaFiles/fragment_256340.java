while ((sCurrentLine = br.readLine()) != null){
    if (sCurrentLine.isEmpty() || sCurrentLine.startsWith(";")) // skip empty and comment lines
        continue;

    String[] values = sCurrentLine.split("\\t"); // are you sure the -1 is required?
...
}