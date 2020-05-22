String text = "text";
JButton[] arr = {button1, button2, button3};
Random r = new Random();
JButton b = arr[r.nextInt(arr.length)];
b.setText(text);
b.setEnabled(false);