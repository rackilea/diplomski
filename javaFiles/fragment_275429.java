Iterator<Entry<List<Integer>, Set<String>>> k = partitions.entrySet().iterator();
while (k.hasNext())
{
Entry<?, Set<String>> pair = (Entry<?, Set<String>>)k.next();
int sizeOfSet = pair.getValue().size();
if (sizeOfSet > biggestPartitionSize)
{
     biggestPartitionSize = sizeOfSet;
}