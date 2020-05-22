// See here, the .class argument passed is the type of parameter
// You're using `ent.getClass()` here. It won't work
Method method = ent.getMethod("input", String.class);

// then while invoking this method, you pass the argument:
// Call `invoke()` method of `Method` class
// First arg is the instance on which this method should be called
// Remaining arg is the argument to be passed to the method itself.
result = method.invoke(ent, args);