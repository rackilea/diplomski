struct cmp
{
    bool operator()(const Item & it1, const Item & it2)    // pass by a const reference
    {
        return it1.dist > it2.dist;
    }
};