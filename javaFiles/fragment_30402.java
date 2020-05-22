@Override
protected Set<T> compute()
{
    if (urlsToCrawl.size() <= config.getMaximumUrlsPerTask())
    {
        crawlPage(urlsToCrawl);
    }
    else
    {
        final AbstractUrlTask<T, D> rightTask = createNewOwnInstance(createSubSet(urlsToCrawl));
        final AbstractUrlTask<T, D> leftTask = createNewOwnInstance(urlsToCrawl);
        leftTask.fork();
        taskResults.addAll(rightTask.compute());
        taskResults.addAll(leftTask.join());
    }
    return taskResults;
}

private ConcurrentLinkedQueue<D> createSubSet(final ConcurrentLinkedQueue<D> aBaseQueue)
{
    final int halfSize = aBaseQueue.size() / 2;
    final ConcurrentLinkedQueue<D> urlsToCrawlSubset = new ConcurrentLinkedQueue<>();
    for (int i = 0; i < halfSize; i++)
    {
        urlsToCrawlSubset.offer(aBaseQueue.poll());
    }
    return urlsToCrawlSubset;
}