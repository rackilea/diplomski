// The Client starts and receive the current Server time and the nanoTime
private long         serverTime = server.getCurrentTime();
private long         systemNano = System.nanoTime();

//To calculate the current Server time without a service call
                                                                        //ns-> ms
long currentServerTime = serverTime + ((System.nanoTime() - systemNano) / 1000000);