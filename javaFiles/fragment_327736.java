static void setValue(Example obj, int val) {
    obj.val = val;
}

Example sharedObj = ...;

new Thread(() -> { setValue(sharedObj, 1); }).start();
new Thread(() -> { setValue(sharedObj, 2); }).start();