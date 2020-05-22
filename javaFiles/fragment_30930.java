class ArticalComparatorSet implements Comparator<Artical>
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
        else{ 
            return 0;
        }
    }

}