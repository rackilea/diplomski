// ======= EventBus Subscribers =======
@Subscribe(threadMode = ThreadMode.MAIN_ORDERED)
public void onEvent(ActionEvent event)
{
    // Maniupulate the UI directly
    titleTextView.setText(event.getTitle());
    messageTextView.setText(event.getMessage());
}