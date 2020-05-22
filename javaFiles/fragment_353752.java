for (int i=0; i<fileList.length;i++) {
    Upload up = new Upload();
    FutureTask<Integer> future = new FutureTask(up);
    future.run();
    int result = future.get();
}