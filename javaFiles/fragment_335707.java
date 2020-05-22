if (selected == 0 && elapsed < timeout)
{
    keyIter = selector.keys().iterator();
    while (keyIter.hasNext())
    {
        key = keyIter.next();
        if (key.isValid())
        {
            channel = (SocketChannel)key.channel();
            if (channel != null)
            {
                if ((key.interestOps() & SelectionKey.OP_CONNECT) != 0)
                {
                    if (channel.finishConnect())
                    {
                        key.interestOps(0);
                    }
                }
            }
        }
    }
}