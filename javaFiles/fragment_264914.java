............
meaning = meaning.replaceAll("\\s+", " ");

/*compare the given input with the meaning of the read line */
if(meaning.equalsIgnoreCase(f_msg3)) {
     txtView.setText(f_msg3);
} else {
     txtView.setText(f_msg);
}
............