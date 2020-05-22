} catch (FileNotFoundException e) {
    xmlList = "URL: FileNotFoundException";
    e.printStackTrace();
} catch (EOFException e) {
    xmlList = "URL: EOFException";
    e.printStackTrace();
} catch (IOException e) {
    xmlList = "URL: IOException";
    e.printStackTrace();
}