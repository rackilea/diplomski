//Create interface in your adapter or do what you want, but like this

public void onNodeClicked(long nextId, int currentPosition){
    Node next;
    if(currentPosition == questions.size() - 1){
        next = getNodeById(nextId);
        question.add(next);
    }else{
        next = questions.get(position + 1);
        if(nextId != next.getId()){
            ArrayList<Node> remove = new ArrayList<>();
            remove.addAll(position + 1, questions);
            questions.removeAll(remove);
            next = getNodeById(nextId);
            question.add(next);
        }
    }
    adapter.notifyDataSetChanged();
}