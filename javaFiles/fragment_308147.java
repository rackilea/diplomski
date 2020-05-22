let a: [2, 1, 10, 9]
let b: [1, 5, 2, 7, 6]

let result: []

Arrays.sort(a); // a: [1, 2, 9, 10]
Arrays.sort(b); // b: [1, 2, 5, 6, 7]

loop(...)
| 1: add 1 to result, increment i & j
| 2: add 2 to result, increment i & j
| 3: (j == 2) increment only j (5 < 9)
| 4: (j == 3) increment only j (6 < 9)
| 5: (j == 4) increment only j (7 < 9)
| 6: (j == 5) stop because j >= b.size()

return result // [1, 2]