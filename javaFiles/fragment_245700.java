public static void main(String[] args) {
File f = new File("/temp/t.txt");
long lastModified = f.lastModified();
long currentTime = System.currentTimeMillis();
long difference = currentTime - lastModified;
// time is in milliseconds, one hour is 60 * 60 * 1000 milliseconds
long oneHour = 1000 * 60 *60;
if (difference > oneHour)
    System.out.println("file is not modified");
else
    System.out.println("that file is modified");
}