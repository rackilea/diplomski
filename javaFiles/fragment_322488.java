if(j*k == sum-(j+k)){
                    //System.out.println("j:"+j+" k:"+k);
                    long[] pairs_current = new long[2];
                    pairs_current[0] = j;
                    pairs_current[1] = k;
                    list_all.add(pairs_current);
                    System.out.println("pairs_current:"+Arrays.toString(pairs_current));
                    System.out.println("list_all:"+Arrays.deepToString(list_all.toArray()));
                }