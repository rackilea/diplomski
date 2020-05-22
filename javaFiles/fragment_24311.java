function merge_intervals(a)
{ // this function save the result IN PLACE
    if (a.length == 0) return;
    var st = a[0][0], en = a[0][1], k = 0;
    for (var i = 1; i < a.length; ++i) {
        if (a[i][0] > en) { // a new interval
            a[k++] = [st, en];
            st = a[i][0], en = a[i][1];
        } else en = a[i][1] > en? a[i][1] : en;
    }
    a[k++] = [st, en]; // add the last interval
    a.length = k; // discard the rest
}

// intervals are half-close-half-open, like C arrays
var a = [[1,10], [20,40], [30,50], [55,65], [65,80], [75,90], [95,100]];
// sort the intervals based on start positions
a.sort(function(x,y) { return x[0]-y[0] });

merge_intverals(a);
for (var i = 0; i < a.length; ++i)
    console.log(a[i].join("\t"));