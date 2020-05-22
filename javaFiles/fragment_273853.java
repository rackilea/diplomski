singleVote = singleVote.toUpperCase()
switch (singleVote) {
    case "A":
        aCount = aCount + 1;
        break;
    case "B":
        bCount = bCount + 1;
        break;
    default:
        invalidCount = invalidCount + 1;
}