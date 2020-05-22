TreeMap<Double,Integer> limits = new TreeMap<Double,Integer>();
limits.put(0.2, 1);
limits.put(0.5, 2);
limits.put(0.9, 3);
...
Map.Entry<Double,Integer> e = limits.ceilingEntry(a);
if (e != null) {
    switch(e.getValue()) {
        case 1: ... break;
        case 2: ... break;
        case 3: ... break;
    }
}