BigInt input1 = new BigInt();
BigInt multiplier = new BigInt();

BigInt nextResult = new BigInt();
BigInt lastResult = null;

while ( ... notdone ... ) {
    nextResult.digitList.clear();
    if (lastResult==null) {
        lastResult = input1;
    } else {
        ... the addition logic: nextResult = lastResult + input1 ...
    }
    ... the logic to remember that one addition step was done ...

    lastResult = nextResult;
    nextResult = new BigInt();
}