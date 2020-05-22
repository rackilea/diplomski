Map<String,Integer> sortedTree = new TreeMap<String,Integer>();
            System.out.println(sortedTree.toString());
            Iterator<Entry<String,Integer>> itr = sortedTree.entrySet().iterator();
            while(itr.hasNext())
            {
                Entry<String,Integer> entry = itr.next();
                if(entry.getKey().equals("A"))
                    itr.remove();
            }