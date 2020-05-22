switch (singleVote) {
    case "A":
    case "a":
        aCount = aCount + 1;
        break;
    case "B":
    case "b":
        bCount = bCount + 1;
        break;
    default:
        invalidCount = invalidCount + 1;
}