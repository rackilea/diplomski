function test() {
    var i;           // declaration hoisted
    console.log(i);  // undefined
    i = 1;           // assignment still happens here
    console.log(i);  // 1
}