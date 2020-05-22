ArrayList<File> Songs = addSongList( dir );

for(int i = 0; i < Songs.size(); i++){
   try {
        Path sourcePath = Songs.get(i).toPath();
        Path targetPath = Paths.get(Songs.get(i).getName()).toAbsolutePath();

        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Copied " + Songs.get(i).getName() + " to " + targetPath.toString());
        } catch (IOException arg0) {
               // TODO Auto-generated catch block
                arg0.printStackTrace();
            }
}
System.out.println("Copy Complete!");