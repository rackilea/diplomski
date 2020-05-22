if(!resultset1.next()) {
    //advanced to the first row, but not consumed
    while(resultset1.next()){
        //advanced to the following row
        //consumed this one...

        resultset1.next();
        //yet again advancing to the next row
        //and not consuming it
    }
}