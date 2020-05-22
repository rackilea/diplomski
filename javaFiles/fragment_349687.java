int numCols = 2;
int numRows = 10;

for(int i=1;i<=numCols;i++)
{
    fLayout.appendColumn(FormFactory.RELATED_GAP_COLSPEC);
    fLayout.appendColumn(FormFactory.DEFAULT_COLSPEC );
}

for(int j=1;j<=numRows;j++)
{
    fLayout.appendRow(FormFactory.RELATED_GAP_ROWSPEC);
    fLayout.appendRow(FormFactory.DEFAULT_ROWSPEC);;
}
this.setLayout(fLayout);