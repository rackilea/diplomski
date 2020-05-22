synchronized(queue)
{
    for (int i = 0; i < queue.size(); i++)
    {
        queue.remove(0).run();
    }
}