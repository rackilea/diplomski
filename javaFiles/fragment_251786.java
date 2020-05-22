void onTimerExecutes(){
    offset++;
    if (offset >= colors.length)
        offset = 0;
    applyColorsToText();
}