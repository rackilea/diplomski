final CountDownLatch latch = new CountDownLatch(concurrent);   

for (int i=0;i<concurrent;i++)
{
    ConcurrentExchange ex = new ConcurrentExchange(client,latch,uris,repeats);
    if (!ex.next()) // this executes the client.send()
    {
        latch.countDown(); // count down if client.send() was in error
    }
}

latch.await(); // wait for all ConcurrentExchange's to complete (or error out)