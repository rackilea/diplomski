long a = System.currentTimeMillis();
    Object[] sol=solve(10, new ArrayList<Integer>(),Integer.MAX_VALUE,new HashMap<Integer,Integer>()).toArray();
    System.out.println(sol.length);
    System.out.println(Arrays.toString(sol));
    System.out.println((System.currentTimeMillis()-a));
}