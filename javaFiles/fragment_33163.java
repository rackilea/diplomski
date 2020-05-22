...
// Get the item only once, then reuse it.
Uebersichtliste item = liste.get(position);

holder.titel.setText(item.getTitel());
holder.underline.setText(item.getUnderline());
holder.text.setText(item.getText());
...

holder.text.setTextColor(litem.getTextffarbe());