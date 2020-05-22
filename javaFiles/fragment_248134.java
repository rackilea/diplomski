int cnt = 0;
for (z=0; z<daRun.length; z++){
    if(daRun[0][z] == dMaxScoreRun1 || daRun[0][z] == dMinScoreRun1)
          continue;
    dTotalRun1 += daRun[0][z];
    cnt++;
}

if( cnt != 0 ){
    dAvgRun1 = dTotalRun1 / cnt;
} else {
    // ? not sure what to use here
}