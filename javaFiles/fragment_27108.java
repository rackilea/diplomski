PriorityQueue removelast(PriorityQueue pq)
{

    PriorityQueue pqnew;

    while(pq.size() > 1)
    {
        pqnew.add(pq.poll());
    }

    pq.clear();
    return pqnew;
}