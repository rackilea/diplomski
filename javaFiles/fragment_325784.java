import * as module1 from '/path/yourModule';

class yourComponent {
    function test() {
        module1.a(); // call function a from module
    }
}
// In this case, you won't have to worry about duplicated function's name, but you still
// have to check duplicated of the name of modules you have imported. For this example,
// the name module1 has been used.