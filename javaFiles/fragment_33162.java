...
holder.titel.setText(liste.get(position).getTitel());
holder.underline.setText(liste.get(position).getUnderline());
holder.text.setText(liste.get(position).getText());
Log.e("Test",String.valueOf(liste.get(position).getTextffarbe()));
Log.e("Test",String.valueOf(liste.get(position).getBildfarbe()));
holder.text.setTextColor(liste.get(position).getTextffarbe());

...