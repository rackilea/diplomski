// erase from line 4 to 6
int startingLineNumber= 6;
// Access the code attribute
CodeAttribute codeAttribute = mymethod.getMethodInfo().getCodeAttribute();

LineNumberAttribute lineNumberAttribute = (LineNumberAttribute)      codeAttribute.getAttribute(LineNumberAttribute.tag);

// Index in bytecode array where we start to delete
int firstIndex = lineNumberAttribute.toStartPc(startingLineNumber);

// Index in the bytecode where the first instruction that we keep starts
int secondIndex = lineNumberAttribute.toStartPc(startingLineNumber+2);

// go through the bytecode array
byte[] code = codeAttribute.getCode();
for (int i = firstIndex ; i < secondIndex ; i++) {
   // set the bytecode of this line to No OPeration
   code[i] = CodeAttribute.NOP;
}