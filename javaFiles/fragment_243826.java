while(!list.isEmpty()){
    int n = (Integer) list.poll();
    for(int x = 0; x< adj[n-1].size();x++){
        tmpList.add(adj[n-1].get(x));
    }

    if(list.isEmpty()) {
        if(counter == level){
            System.out.println(tmpList.size());
            break;
        }

        list.addAll(tmpList);
        tmpList.clear();
        counter++;
    }
}