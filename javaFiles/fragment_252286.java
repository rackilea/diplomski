final Iterator<Transition> it = this.transitions.iterator();
final List<Transition> tmp = new ArrayList();//using a list will keep the order
while(it.hasNext()) {
    final Transition object = it.next();

    if(object.id == 3){
        it.remove();
        tmp.add(object);
    }
}
this.transitions.addAll(tmp);