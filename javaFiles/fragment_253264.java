public class Explorer {

    List<NataCenter> nataCenter;


    public List<NataCenter> getNataCenter() {
        return nataCenter;
    }

    public void add(NataCenter nataCenterItem){
        if(nataCenter == null){
            nataCenter = new LinkedList<>();
        }
        nataCenter.add(nataCenterItem);
    }
}