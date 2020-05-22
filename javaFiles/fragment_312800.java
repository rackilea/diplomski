public static int[] findTwoSum(int[] list, int sum) 
{
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i=0; i<list.length; i++) 
        {
            int req = sum - list[i];
            if (hmap.get(req) != null) 
                return new int[]{i, hmap.get(req)};

            hmap.put(list[i], i);
        }

        return null;    
}