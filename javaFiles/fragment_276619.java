//assuming the height as variable - 'r'
//take an input of some element, let's assume a[0][0], taken inside a[e][e]

int f, f1, f2, arflg=0;
int arr = new int[r*r];
for(int i=0;i<r;i++){
    for(int j=0;j<r;j++){
        arr[arflg]=a[i][j];
        arflg++;
        if(a[i][j]==a[e][e]) f1 = arflg; //location of element entered on the array
        if(a[i][j]==a[e][e]-1) f2 = arflg; //location of element's predecessor on the array
    }
}
f = f2 - f1;
if(f==1){
//forward hortizontal
}elseif(f==-1){
//backward horizontal
}elseif(f==r){
//below
}elseif(f==r-1){
//below left
}elseif(f==r+1){
//below right
}elseif(f==-r){
//above
}elseif(f==(-r-1)){
//above left
}elseif(f==(-r+1){
//above right
}