MyClass<Integer> myClassWithInteger = new MyClass<Integer>();
myClassWithInteger.someInstance = someInteger;

// This is valid
MyClass<? extends Object> myClassWithWildcard = myClassWithInteger; 

// This is NOT valid, but let's assume it was:
MyClass<Object> myClassWithObject = myClassWithWildcard; 

// This would be valid, because 'someInstance' was of type 'Object' here
myClassWithObject.someInstance = "someString";

// This is valid. But through the unchecked cast, we silently
// sneaked in an STRING as this instance. So this would fail:
Integer i = myClassWithInteger.someInstance;