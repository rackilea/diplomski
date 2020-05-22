Document document = document = Jsoup.connect(URL).get(); //get the HTML page
Elements rows = document.select("table > tbody > tr"); //select all rows
int[] offsets = new int[rows.size()];

for (int i = 0; i < rows.get(0).children().size(); i++) //unless colspans are used, this should return the number of columns
{
    for (int j = 0; j < rows.size(); // loops through the rows of each column
    {
        Element cell = rows.get(j).child(i + offsets[j]); //get an individual cell

        if (cell.hasAttr("rowspan")) //if that cell has a rowspan
        {
            int rowspan = Integer.parseInt(cell.attr("rowspan"));

            for (int k = 1; k < rowspan; k++)
            {
                offsets[j + k]--; //add offsets to rows that now have a cell "missing"
            }

            j += rowspan - 1; //add rowspan to index, to skip the "missing" cells
        }
    }
}