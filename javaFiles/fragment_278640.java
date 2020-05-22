int e[] = a.clone();

for (int i = 0; i < a.length; i++){
    if( e[i]%2 == 0){
        e[i] = 0;
    }
}