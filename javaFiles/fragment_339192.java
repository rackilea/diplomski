MethodHandle handle = [...]; // method handle representing f(x1, x2) = x1 + (x2 - 2)
MethodHandle h_permute = MethodHandles.permuteArguments(
     handle,
     handle.type().dropParameterTypes(1, 2), // new handle type with 1 less param
     0, 
     0);
// h_permute now represents f(x) = x + (x - 2)