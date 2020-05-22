public class mainAdapter extends CardScrollAdapter {

   private List<CustomCard> mCards;
   private LayoutInflater inflater;

   public mainAdapter(List<CustomCard> cards, LayoutInflater inf)
   {
       this.mCards = cards;
       this.inflater = inf;
   }

   @Override
   public int getCount() {
       return mCards.size();
   }

   @Override
   public Object getItem(int i) {
       return mCards.get(i);
   }

   @Override
   public View getView(int i, View view, ViewGroup viewGroup) {
       int card = mCards.get(i).getLayout();
       view = inflater.inflate(card, viewGroup, false);
       return view;
   }

   @Override
   public int getPosition(Object o) {
       return this.mCards.indexOf(o);
   }
}