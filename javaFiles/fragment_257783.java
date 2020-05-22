public class Stack { 
    ...
    public int transferValue(Stack source) {
        int res = source.pop();  // throws exception if source is empty
        this.push(value);
        return res;
    }
}