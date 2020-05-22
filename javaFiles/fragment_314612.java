//ClassOrInterfaceDeclaration/ClassOrInterfaceBody [
 count(descendant::MethodDeclarator[
 ..[@Public='true']
  and
 not
 (
  starts-with(@Image,'get')
   or
  starts-with(@Image,'set')
   or
  starts-with(@Image,'is')
 )
 ] ) &gt; $maxmethods
]