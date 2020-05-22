A old = loadedFooInstance.getA();
oldA.setFoo(null);
C c = new C();
c.setFoo(loadedFooInstance);
/*and it is good practic to update foo too*/
loadedFooInstance.setA(c);