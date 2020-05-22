@$Annotation$ // min: 0, max: 0, text/regexp: SomeAnnotation
class $C$ {} // min: 1, max: 1

// Complete Match - Script text: 
if (C instanceof com.intellij.psi.PsiIdentifier) C = C.parent
C.containingClass == null