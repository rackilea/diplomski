class ArticalComparatorSort implements Comparator<Artical>
{

    @Override
    public int compare(Artical a1, Artical a2)
    {
        if(a1.getArticalid() < a2.getArticalid()){
            return -1;
        }
        else if(a1.getArticalid() > a2.getArticalid()){
            return  1;
        }
        else{ // When both id are equals
            return Double.compare(a2.getArticalVersion(), a1.getArticalVersion());
        }
    }

}