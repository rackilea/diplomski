long durationseconds;
int MAX_LOOPS = 20;

for (int len = minlen; len <= maxlen; len *= 2) {
        if (myrank == 0) {
                durationseconds = 0;
                for (int i = 0; i < MAX_LOOPS; i++) {
                        long startTime = System.nanoTime();           
                        MPI.COMM_WORLD.Send(sendbuff, 0, len, MPI.CHAR, 1, tag);
                        MPI.COMM_WORLD.Recv(recvbuff, 0, len, MPI.CHAR, 1, tag);
                        long endTime = System.nanoTime();
                        long duration = endTime - startTime;
                        durationseconds = durationseconds + (duration * 10-9);
                }
                durationseconds = durationseconds / MAX_LOOPS;
                System.out.println("Average time for the ping to be sent and recived of " + (len*2) + " bytes is " + durationseconds + " seconds");
                double transferRateMb = ((len*524288.0) / durationseconds );
                System.out.println("average transferRate (megabytes) : " + transferRateMb + " megabytes per second");
        } else if (myrank == 1) {
                MPI.COMM_WORLD.Recv(recvbuff, 0, len, MPI.CHAR, 0, tag);
                MPI.COMM_WORLD.Send(recvbuff, 0, len, MPI.CHAR, 0, tag);
        }
}