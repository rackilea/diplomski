for(i=0;i<9;i++)
        outerLoop:
        for(j=0;j<9;j++){
            if(board[i][j]>0)continue;
            for(val=1;val<10;val++){                                        
                for(k=0;k<9;k++){
                    if(board[i][k]==val)break;                               
                    if(board[k][j]==val)break;                                  
                }
                for(k=(i/3)*3;k<(i/3+1)*3;k++)                              
                    for(l=(j/3)*3;l<((j/3+1)*3);l++)
                        if(board[k][l]==val)break;                      
                temp[i][j]=val;                                             
                Solve(temp);                                                
            }
    }
    return null;                                                            
}