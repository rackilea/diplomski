// call item.getBildfarbe() only once.
// bildfarbe is a drawable resource id (guessing)
int bildfarbeResId = item.getBildfarbe();

// and convert to string
String bildfarbe = (String) bildfarbeResId;

if(bildfarbe.contains("drawable_border")) {
   holder.background.setBackgroundResource(bildfarbeResId);
} else if(bildfarbe.contains("drawable")) {
   holder.bild.setImageResource(bildfarbeResId);
} else {
   holder.background.setBackgroundColor(bildfarbeResId);
}