// Retrieve the target method by name
let methodTarget = Methods.WithFullName(""myNamespace.MyClass.MyMethod()"").Single()

// Build a ICodeMetric<IMethod,ushort> representing the depth of indirect
// call of the target method.
let indirectCallDepth = 
   methodTarget.ToEnumerable()
   .FillIterative(
       methods => methods.SelectMany(
          m => m.MethodsCallingMe.Union(m.OverriddensBase)))

from m in indirectCallDepth.DefinitionDomain
select new { m, callDepth = indirectCallDepth[m]  }