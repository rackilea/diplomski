tempEditText = (EditText) addView.findViewById(R.id.nrOfSharesInPortfolioEdit);
tempEditText = (EditText) addView.findViewById(R.id.nrOfSharesInPortfolioEdit);
tempEditText.setText(Portfolio.getPortfolio().getShareHolding(positionList).getNrOfSharesInPortfolio());
System.out.println(Portfolio.getPortfolio().getShareHolding(positionList).getNrOfSharesInPortfolio());
tempEditText = (EditText) addView.findViewById(R.id.currentCourseEdit);
tempEditText.setText(Double.toString(Portfolio.getPortfolio().getShareHolding(positionList).getCurrentRate()));

new AlertDialog.Builder(DetailShareHoldingActivity.this)
    .setTitle("Köp " + Portfolio.getPortfolio().getShareHolding(positionList).getName() +  " Aktier")
    .setView(addView)
    .setPositiveButton("Köp", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
            System.out.println("Button pressed köp ");
        }
    })
    .setNegativeButton("Avbryt", null)
    .show();