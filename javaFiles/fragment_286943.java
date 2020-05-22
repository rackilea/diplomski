public List<Integer> getCoords()
{
    final List<Integer> ret = new ArrayList<>();
    for (final List<Integer> l: coords)
        ret.addAll(l);
    return ret;
}