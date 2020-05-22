if (firstArray[a][b]=='0' || firstArray[a][b]=='1' || 
    firstArray[a][b]=='2' || firstArray[a][b]=='3') {
    generate.setColor(66,167,243);
    for (int da=0; da<3; da++) {
        for (int db=0; db<3; db++) {
            generate.plot(a*3+da,b*3+db);
        }
    }
}