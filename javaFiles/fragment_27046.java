CompilationUnit:
        [[Annotations] package QualifiedIdentifier   ;  ] {ImportDeclaration}
{TypeDeclaration}

ImportDeclaration:
     import [ static] Identifier {   .   Identifier } [   .     *   ] ;