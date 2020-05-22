public static void main(String[] args)
    {
        Comparator<AtomicInteger> comparator = new AtomicIntegerComparater();
        PriorityQueue<AtomicInteger> queue =
                new PriorityQueue<AtomicInteger>(10, comparator);
        AtomicInteger lessInteger = new AtomicInteger(10);
        AtomicInteger middleInteger = new AtomicInteger(20);
        AtomicInteger maxInteger = new AtomicInteger(30);
        queue.add(lessInteger);
        queue.add(middleInteger);
        queue.add(maxInteger);
        while (queue.size() != 0)
        {
            System.out.println(queue.remove());
        }



        queue.add(lessInteger);
        queue.add(middleInteger);
        queue.add(maxInteger);

        lessInteger.addAndGet(30);
        while (queue.size() != 0)
        {
            System.out.println(queue.remove());
        }
    }
    }



class AtomicIntegerComparater implements Comparator<AtomicInteger>
{
    @Override
    public int compare(AtomicInteger x, AtomicInteger y)
    {

        if (x.get() < y.get())
        {
            return -1;
        }
        if (x.get() > y.get())
        {
            return 1;
        }
        return 0;
    }
}