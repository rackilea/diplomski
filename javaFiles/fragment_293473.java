@Override
protected void process(List<Progress> progressList) {
    for (Progress p : progressList){
        System.out.println(p.getTask() + " : " + p.getElement());
    }
}