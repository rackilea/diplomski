String arrCells[] = htmlTableText.split(" ");
    Boolean bIsANumber = false;
    for(int i = 0; i < arrCells.length; i++) {

        try {
            int tmp = Integer.parseInt(arrCells[i]);
            bIsANumber = true;
        }
        catch(Exception ex) {
            bIsANumber = false;
        }

        if(bIsANumber) {
            System.out.print("\n"+arrCells[i]+"\t");
        }
        else {
            System.out.print(arrCells[i]+"\t");
        }
    }