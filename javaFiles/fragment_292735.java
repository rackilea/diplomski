int index = 1;
while (true) {
    final String source = "autoexec" + index + ".txt";
    if (new File(source).exists()) {            
        Files.copy(Paths.get(source), Paths.get(path + "\\backup_file" + index + ".txt")); 
        index++;
    } else {
        break;
    }
}