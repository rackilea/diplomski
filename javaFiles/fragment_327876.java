String path = "C:\\...\\test\\";

void setup() {
    move();
}

void draw() {
}

void move() {

    File dir1 = new File(path);
    if (dir1.isDirectory()) {

        //Get all files as array from the source directory
        File[] content = dir1.listFiles();

        //Iterate through each file
        for (int i = 0; i < content.length; i++) {
            //Get the file original Path
            Path source = Paths.get(content[i].getPath());
            //Get the file destination path by appending File name to the new Path
            Path newpath = Paths.get("C:\\...\\test123\\" + source.getFileName());

            //Move the files
            try {
                Files.move(source, newpath);
            } catch (IOException e) {
                print(e);
            }
        }
    }
}