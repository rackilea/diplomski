finally {
    f1.close();
    if(file != null && file.exists()) {
        file.delete();
    }
}