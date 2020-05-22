pieChart.getDescription().setText("Description Text goes here"); //the text which will be displayed. 

pieChart.getDescription().setTextSize(16f); //sets the size of the label text in density pixels min = 6f, max = 24f, default is 10f, font size will be in dp

pieChart.getDescription().setTextColor(ContextCompat.getColor(context, android.R.color.holo_red_dark)); //the color of the font 


pieChart.getDescription().setTextAlign(Paint.Align.RIGHT); //Sets the text alignment of the description text. Default RIGHT