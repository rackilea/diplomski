function MyClass() {
    var words = "hello";
    this.getWords = function() {
        return words;
    };
}

var instance = new MyClass();
console.log(instance.getWords());