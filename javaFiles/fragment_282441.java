int startTime = System.currentTimeMillis();
firstFileEncryptorThread.start();
secondFileEncryptorThread.start();
thirdFileEncryptorThread.start();

firstFileEncryptorThread.join();
secondFileEncryptorThread.join();
thirdFileEncryptorThread.join();

System.out.println(System.currentTimeMillis() - startTime );