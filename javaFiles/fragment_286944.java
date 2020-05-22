public List<Integer> getCoords()
{
    final List<Integer> ret = new ArrayList<>();
    coords.stream().forEach(ret::addAll);
    return ret;
}