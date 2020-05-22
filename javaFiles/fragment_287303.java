String[] configs = config.split("");
String [][] endState = new String[4][4];        
int i = 17;        
for(int r=0;r<endState.length;r++){
    for(int c=0;c<endState.length;c++){
        endState[r][c] = configs[i++];
    }
}