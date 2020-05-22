while(!stk.isEmpty()){
        for(T n : succ.get(stk.pop())){
        if(!mark.contains(n)){
            stk.push(n);
            mark.add(n);
        }
    }
}