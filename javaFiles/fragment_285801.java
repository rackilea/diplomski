waitingRoom.acquire();

barber.acquire();
waitingRoom.release()

Thread.sleep(300)

barber.release()