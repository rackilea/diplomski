public List<Riviz> getDuplicates(final List<Riviz> l)
{
    final HashMap<String, List<Riviz>> m = new HashMap<String, List<Riviz>>();
    final List<Riviz> ret = new ArrayList<Riviz>();

    String cnk;

    for (final Riviz r: l) {
        cnk = r.getCnk();
        if (!m.contains(cnk))
            m.add(cnk, new ArrayList<Riviz>());
        m.get(cnk).add(r);            
    }

    List<Riviz> tmp;
    for (final Map.Entry<String, List<Riviz>> entry: m.entrySet()) {
        tmp = entry.getValue();
        if (tmp.size() == 1) // no dups
            continue;
        ret.addAll(tmp);
    }

    return ret;
}