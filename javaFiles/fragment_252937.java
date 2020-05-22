public class workPls {
    public LinkedList<PlsWork> list = new LinkedList<>();

    public void addNode(PlsWork st){
        list.add(st);
    }

    public LinkedList<PlsWork> getList() {
        return list;
    }

    public void print(){
        for (PlsWork p: list) {
            System.out.println(p.getIp());
        }
}