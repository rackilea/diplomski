ReceiveMessage firstReceiver;
ReceiveMessage secondReceiver;

@Override
public void onAttachFragment(Fragment fragment) {
    super.onAttachFragment(fragment);
    if (fragment instanceof FirstFragment) {
       firstReceiver = (ReceiveMessage) fragment;
    } else if (fragment instanceof SecondFragment) {
       secondReceiver = (ReceiverMessage) fragment;
    } 
}



button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String name = editText.getText().toString().trim();
             firstReceiver.receiveMessage(name, 3);
             secondReceiver.receiveMessage(name, 3); 
        }
});