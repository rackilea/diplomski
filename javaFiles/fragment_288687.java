for (int i = 1; i < 10; i++) {
    gridPath.moveTo(getPaddingLeft() + squareWidth * i, top);
    gridPath.lineTo(getPaddingLeft + squareWidth * i, bot);
}

for (int i = 1; i < 10; i++){
    gridPath.moveTo(left, getPaddingTop() + squareHeight * i);
    gridPath.lineTo(right, getPaddingTop() + squareHeight * i);
}