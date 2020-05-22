if (domainData < copiedppList.size() - 1)
{
    copiedppList.get(domainData + 1); // This is now safe, assuming
                                      // nothing reduces the size of
                                      // copiedppList since the if check.
}