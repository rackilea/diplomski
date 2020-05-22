Iterator<Entry<String, Double>> it = mp.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry<String, Double> pair = it.next();
        System.out.println(pair.getKey() + " = " + pair.getValue());
        //Need to know how to compare in next line
        if(pair.getValue() >= m_asim) // this line give me error
        {}

        it.remove(); 
    }