const
    getPattern = a => a.map(v => v ? 1 : 0).join('');

var csv = [',1,,2,,3,x,4,', ',1,,2,,3,,4,', ',1,,2,,3,,4,', ',1,,2,,3,,4,', ',1,,2,,3,,4,', ',1,,2,,3,,4,', ',1,,2,,3,,4,', ',1,,2,,3,,4,', ',1,,2,,3,,4,', '1,2,3,4,,,,,', '1,2,3,4,,,,,', '1,2,3,4,,,,,', '1,2,3,4,,,,,', '1,2,3,4,,,,,', '1,2,3,4,,,,,', '1,2,3,4,,,,,', '1,2,3,4,,,,,', '1,2,3,4,,,,,'],
    arrays = csv.map(s => s.split(',')),
    total = 0,
    columns = arrays.reduce((r, a) => {
        var p = getPattern(a);
        r[p] = r[p] || { count: 0 };
        r[p].count++;
        total++;
        return r;
    }, {}),
    patterns = Object.keys(columns),
    result;

patterns.forEach(p => {
    if (columns[p].count / total >= .1) {
        columns[p].filter = p;
        return;
    }
    columns[p].filter = Array
        .from(p, (v, i) => patterns.reduce((t, p) => t + v * p[i] * columns[p].count, 0) / total >= .1 ? 1 : 0)
        .join('');
});

result = arrays.map(a => (f => a.filter((_, i) => +f[i]))(columns[getPattern(a)].filter));

console.log(result);
console.log(columns);