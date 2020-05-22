public static Person max(Person a, Person b, Person c, Person d) {

    Person max = a;

    if (b.getVotes() > max.getVotes())
        max = b;
    if (c.getVotes() > max.getVotes())
        max = c;
    if (d.getVotes() > max.getVotes())
        max = d;

     return max;
}