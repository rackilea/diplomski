protected PriorityQueue<OrderedRenderableEntry> orderedRenderables =
    new PriorityQueue<OrderedRenderableEntry>(100, new Comparator<OrderedRenderableEntry>()
    {
        public int compare(OrderedRenderableEntry orA, OrderedRenderableEntry orB)
        {
            double eA = orA.distanceFromEye;
            double eB = orB.distanceFromEye;

            return eA > eB ? -1 : eA == eB ? (orA.time < orB.time ? -1 : orA.time == orB.time ? 0 : 1) : 1;
        }
    });