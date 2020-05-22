synchronized (sync) {
    int cnt = 0;
    while (true) {
        try {
            if(file.createNewFile())
                break;
        } catch (IOException e) {
            // continue;
        }
        file = new File(name + " (" + (cnt++) + ")");
    }
}