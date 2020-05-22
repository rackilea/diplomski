public class CompositeOnClickListener implements OnClickListener {
    private final Set<OnClickListener> delegates = new HashSet<OnClickListener>();

    public CompositeOnClickListener(OnClickListener... listeners) {
        for (OnClickListener listener : listeners) {
            delegates.add(listener);
        }
    }

    @Override
    public void onClick(View v) {
        for (OnClickListener listener : delegates) {
            listener.onClick(v);
        }
    } 
}