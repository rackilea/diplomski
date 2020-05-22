Integer randomResource = images[r.nextInt(images.length)];
imageView.setImageResource(randomResource );
if (randomResource == R.drawable.img250) {
   message.setText("Miami Beach is a south Florida island city");
} else {
   // ...
}