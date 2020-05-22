@Override
public int compareTo(Pair other){
    int cmpFirstFirst = first.compareTo(other.first);
    int cmpSecondSecond =  second.compareTo(other.second);
    int cmpFirstSecond = first.compareTo(other.second);
    int cmpSecondFirst =  second.compareTo(other.first);

    if ( cmpFirstFirst == 0 && cmpSecondSecond == 0 || cmpFirstSecond == 0 && cmpSecondFirst == 0) {
        return 0;
    }

    String thisSmaller;
    String otherSmaller;

    String thisBigger;
    String otherBigger;

    if ( this.first.compareTo(this.second) < 0 ) {
        thisSmaller = this.first;
        thisBigger = this.second;
    } else {
        thisSmaller = this.second;
        thisBigger = this.first;
    }

    if ( other.first.compareTo(other.second) < 0 ) {
        otherSmaller = other.first;
        otherBigger = other.second;
    } else {
        otherSmaller = other.second;
        otherBigger = other.first;
    }

    int cmpThisSmallerOtherSmaller = thisSmaller.compareTo(otherSmaller);
    int cmpThisBiggerOtherBigger = thisBigger.compareTo(otherBigger);

    if (cmpThisSmallerOtherSmaller == 0) {
        return cmpThisBiggerOtherBigger;
    } else {
        return cmpThisSmallerOtherSmaller;
    }
}