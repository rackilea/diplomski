ArrayList<HashMap<String, Integer>> expense = new ArrayList<HashMap<String, Integer>>();        
        HashMap<String, Integer> newExpense = new HashMap<>();
        for(HashMap<String, Integer> oldExpense : expense)
        {
            for(String key : oldExpense.keySet())
            {
                if (newExpense.containsKey(key))
                    newExpense.put(key, newExpense.get(key) + oldExpense.get(key));
                else
                    newExpense.put(key, oldExpense.get(key));
            }
        }
        System.out.println(newExpense.toString());