HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
for(int x : A)
{
    Integer v = m.get(x);
    if (null == v) {v = Integer.valueOf(0);}
    m.put(x, ++v);
}