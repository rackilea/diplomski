arr = [[0, 1, 2, 3, 4],
       [0, 0, 5, 6, 7],
       [0, 0, 0, 8, 9],
       [0, 0, 0, 0, 10],
       [0, 0, 0, 0, 0]];

flatArr = [1,2,3,4,5,6,7,8,9,10];

n = 5; // matrix size
i = 1; 
j = 3;

if (j <= i) {

    alert(0);

} else {
    pos = 0;
    // find an offset caused by first (i - 1) lines
    for (k = 1; k < i; k++) {
       pos += n - k;
    }

    // find an offset in line x
    pos += j - i;

    // array index start from 0 so decrement value
    pos = pos - 1;

    alert('flatArr[' + pos + '] = ' + flatArr[pos]);
}