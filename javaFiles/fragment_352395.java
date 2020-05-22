// collect sums
    Map<String, Integer[]> totals = new HashMap<>();
    while ( rsSol.next() ) {
        if ( desc.equals("") ){
            desc =  rsSol.getString("description");
        }
        if ( !desc.equals(rsSol.getString("giro")) && count > 1 ){
            desc = rsSol.getString("giro");
        }
        totals.putIfAbsent(desc, new Integer[12]);
        Integer[] totalSums = totals.get(desc);
        for(int i = 0; i < 12; i++){
            totalSums += values[i];
        }
    }

// print your results
    for (String desc : totals.keySet()) {
       <tr class>
            <td border='0' ALIGN='left'>    desc.toLowerCase()  </td>

                // Where i print the array
                for(int i=1; i<=12; i++){
                <td border='0' ALIGN='right'>   totals.get(desc)  </td>
                }

                // Where i print the sum of all months
            <td border='0' ALIGN='right'>   monthTotal  </td>
        </tr> 
    }