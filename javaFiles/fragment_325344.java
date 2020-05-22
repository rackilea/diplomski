JLabel labelBeingUsed = myLabel;
View view = (View) labelBeingUsed.getClientProperty(BasicHTML.propertyKey);
view.setSize(scrollPane1.getWidth(), 0.0f);
float w = view.getPreferredSpan(View.X_AXIS);
float h = view.getPreferredSpan(View.Y_AXIS);
labelBeingUsed.setSize((int) w, (int) h);