static HashSet recursivFonc(HashSet<Integer> setInteg, HashMap<Integer, Set<Integer>> map, int cont)
    {
        System.out.println(cont);
        if(map.get(cont) != null)
        {
            Set<Integer> set = map.get(cont);
            for(Integer intg : set)
            {

                setInteg.add(intg);
            }
            return recursivFonc(setInteg, map, cont + 1);
        }
        return setInteg;
    }