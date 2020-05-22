int row=-1, col=-1,prevoousrow=-1,prevoouscol=-1 ;   
for (int i = 1; i <= movements; i++) {

    row = scan.nextInt();
    col = scan.nextInt();

    if((prevoousrow == row)  && (prevoouscol == col))
    {
      //duplicate/same movement
    }

    prevoousrow = row;
    prevoouscol = col;
}