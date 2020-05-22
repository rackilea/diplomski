File file = new File(path);
Path sourceZip = file.toPath();
StringBuilder sb = new StringBuilder();
sb.append(new File(System.getProperty("user.dir")).getParent());
sb.append("/");
sb.append(file.getName());
Path target = Paths.get(sb.toString());
try {
   Files.copy(sourceZip, target, StandardCopyOption.REPLACE_EXISTING);
} catch (IOException e) //DirectoryNotEmptyException occurs here
{}