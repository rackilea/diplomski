private static int[] calculateRowsAndColumnsNeeded(int numberOfImages, Dimension containerSize){
    int colsAttempt = 0;
    int rowsAttempt = 0;
    // Calculate the length of one side from a single cell
    int containerArea = containerSize.height * containerSize.width;
    float singleCellArea = containerArea / numberOfImages;
    double cellSideLength = Math.sqrt(singleCellArea);

    colsAttempt = (int) Math.floor(containerSize.width / cellSideLength);
    rowsAttempt =  (int) Math.floor(containerSize.height / cellSideLength);

    if (colsAttempt * rowsAttempt >= numberOfImages){

        return new int[]{rowsAttempt, colsAttempt};

    }
    // If the container is a square or bigger horizontally than vertically
    else if (containerSize.height <= containerSize.width){

        colsAttempt = (int) Math.ceil(containerSize.width / cellSideLength);
        rowsAttempt =  (int) Math.floor(containerSize.height / cellSideLength);

        if (colsAttempt * rowsAttempt >= numberOfImages){
            // 
            return new int[]{rowsAttempt, colsAttempt};

        }else{

            colsAttempt = (int) Math.floor(containerSize.width / cellSideLength);
            rowsAttempt =  (int) Math.ceil(containerSize.height / cellSideLength);

            if (colsAttempt * rowsAttempt >= numberOfImages){
                return new int[]{rowsAttempt, colsAttempt};
            }else{
                colsAttempt = (int) Math.ceil(containerSize.width / cellSideLength);
                rowsAttempt =  (int) Math.ceil(containerSize.height / cellSideLength);

                if (colsAttempt * rowsAttempt >= numberOfImages){
                    return new int[]{rowsAttempt, colsAttempt};
                }else{
                    return null;
                }
            }
        }
    } 
    // If the container is bigger vertically than horizontally
    else {

        colsAttempt = (int) Math.floor(containerSize.width / cellSideLength);
        rowsAttempt =  (int) Math.ceil(containerSize.height / cellSideLength);

        if (colsAttempt * rowsAttempt >= numberOfImages){
            // 
            return new int[]{rowsAttempt, colsAttempt};

        }else{

            colsAttempt = (int) Math.ceil(containerSize.width / cellSideLength);
            rowsAttempt =  (int) Math.floor(containerSize.height / cellSideLength);

            if (colsAttempt * rowsAttempt >= numberOfImages){
                return new int[]{rowsAttempt, colsAttempt};
            }else{
                colsAttempt = (int) Math.ceil(containerSize.width / cellSideLength);
                rowsAttempt =  (int) Math.ceil(containerSize.height / cellSideLength);

                if (colsAttempt * rowsAttempt >= numberOfImages){
                    return new int[]{rowsAttempt, colsAttempt};
                }else{
                    return null;
                }
            }
        }
    }
}