// This works regardless of whether `x` is `int` or `long` 
// and you can safely change the type in the future.
// 1 if negative, 0 if non-negative
x >>> -1;

// works for 32-bit but not 64-bit so if you change the type later,
// it could break without compiler error.
x >>> 31;