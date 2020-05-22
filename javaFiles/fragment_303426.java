Iterator i1 = listOperateur.iterator();
    for (Map.Entry<Integer, ArrayList<Integer>> e : hmm.entrySet()) {

            count = 0;

            for (Integer mapValue : e.getValue()) {

                if (mapValue.equals(listOperateur.get(k))) {
                    count++;

                }
            }
            sim.put(e.getKey(), count);
            k++;

    }