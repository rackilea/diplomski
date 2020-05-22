const
    pipe = (...functions) => input => functions.reduce((acc, fn) => fn(acc), input),
    a = x => { x = x * x; console.log("map1=" + x); return x; },
    b = x => { x = x * 3; console.log("map2=" + x); return x; },
    c = x => console.log("forEach=" + x)

var nums = [1, 2, 3, 4, 5, 6],
    pipeline = pipe(a, b, c);

nums.forEach(pipeline);