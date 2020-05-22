List<Integer> indices = new ArrayList<Integer>();

   for (Double key : smallest.keySet()) {
       List<Integer> list = smallest.get(key);
       for (Integer index : list) {
           indices.add(index);
           if (indices.size() == input) break;
       }
       if (indices.size() == input) break;
   }

   System.out.println(smallest);
   System.out.println(indices);