// We'll say that the variable "reg" contains a rectangle that needs to be redrawn
// We'll make it a fake Renderable so "it" can be searched in the arrays
Renderable rReg = new FakeRenderable(reg);
int topPos    = Arrays.binarySearch(byTop,    rReg, topComp);
int bottomPos = Arrays.binarySearch(byBottom, rReg, bottomComp);
// etc for leftPos and rightPos