public static void cat(File file) {
    boolean readAll = false;
    try (RandomAccessFile input = new RandomAccessFile(file, "r")){
        String line = null;
        while ((line = input.readLine()) != null) {
            System.out.println(line);
        }
        readAll = true;
        return;
    } catch(FileNotFoundException a){
        ;//do something to recover from this exception.
    }catch(IOException b){
        ;//distinguish between close and readLine exception.
        if (readAll) ...
    }
}