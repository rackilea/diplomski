@Override
public void onItemClicked(View view, int position) {
    Context context = view.getContext();
    Intent intent = new Intent(context, ActivityYouNeedToStart.class);
    context.startActivity(intent);
}