if (numOfReaders == 1) {
    accessToResource.acquire();
}
readMutex.release();

System.out.println("Read content:\t" + content);

readMutex.acquire();  // -------> here