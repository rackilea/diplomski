int[] arr = {R.id.A, R.id.B, ... };

for(char letter = 'A'; letter <= 'Z';letter ++){
    final TextView textView = (TextView) getView().findViewById(arr[letter-'A']);
    .....
}