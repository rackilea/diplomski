boolean finishFlag = false;
while(!finishFlag) {
    introPhase();
    gamePhase();
    finishFlag = getExitInfoFromUser();
}