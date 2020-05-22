public void fillScan(Graphics g)
{ //determines the line to be drawn for filling
    for (int i = 0; i < xcoord.length; i += 2)
    {
        drawMyHorizontalLine(g, (int)Math.round(xcoord[i]), scan, (int)Math.round(xcoord[i + 1]));
    }//end for
}//end fillScan