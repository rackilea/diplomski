if (a.equals("if") || a.equals("=")) {         

            // System.out.println(refList);
            if(signs.containsKey(a)){
                signs.get(a).add(index);
            }
            else{
                refList.add(index);
                signs.put(a, refList);
            }
            refList = new ArrayList<Integer>();

            System.out.println(signs);
        }