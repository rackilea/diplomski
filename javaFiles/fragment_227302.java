public static <T> List<T> conditionalRemove(ArrayList<T> list) {
        ConditionCheck<T> cond = new ConditionCheck<>();
        Iterator it = list.iterator();
        while(it.hasNext())     
        {
            it.next();
            if (cond.test(t)) {
                it.remove();
            }
         }
        return list;
    }