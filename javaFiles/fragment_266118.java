__kernel void optimizedModel(
        __global uint *output,
        int sizeX, int sizeY,
        __global uint *colorMap,
        __global uint *oldCellMap,
        __global uint *newCellMap,
        __global uint *historyBuffer
)
{
    // the x and y coordinates that currently being computed
    unsigned int x = get_global_id(0);
    unsigned int y = get_global_id(1);

    int cellValue = historyBuffer[sizeX*y+x];
    int neighborCount = abs(cellValue)-1;
    output[y*sizeX+x] = colorMap[cellValue > 0 ? 1 : 0];

    if(cellValue > 0){// if alive
        if(neighborCount < 2 || neighborCount > 3){
            // kill

            for(int i=-1; i<2; i++){
                for(int j=-1; j<2; j++){
                    if(i!=0 || j!=0){
                        int wxc = wrap(x+i, sizeX);
                        int wyc = wrap(y+j, sizeY);
                        newCellMap[sizeX*wyc+wxc] -= oldCellMap[sizeX*wyc+wxc] > 0 ? 1 : -1;
                    }
                }
            }
            newCellMap[sizeX*y+x] *= -1;

            // end kill
        }
    }else{
        if(neighborCount==3){
            // spawn

            for(int i=-1; i<2; i++){
                for(int j=-1; j<2; j++){
                    if(i!=0 || j!=0){
                        int wxc = wrap(x+i, sizeX);
                        int wyc = wrap(y+j, sizeY);
                        newCellMap[sizeX*wyc+wxc] += oldCellMap[sizeX*wyc+wxc] > 0 ? 1 : -1;
                    }
                }
            }
            newCellMap[sizeX*y+x] *= -1;

            // end spawn
        }
    }
}