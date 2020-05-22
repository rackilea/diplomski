public class InvokeSynchronizer  implements IResourceDeltaVisitor{

private static HashMap<String, IMethod> methodtoinvoke = new HashMap<String, IMethod>();

public boolean visit(IResourceDelta delta) {

       IResource res = delta.getResource();
        switch (delta.getKind()) {

          case IResourceDelta.ADDED:
              System.out.println("ADDED: ");
          break;
        case IResourceDelta.CHANGED:
          /**
               * methodtoinvoke is a hash map values got from the modification store class.
               */
              methodtoinvoke=ModificationStore.getChanged();

               Iterator it = methodtoinvoke.entrySet().iterator();
              while (it.hasNext()) {

                Map.Entry pairs = (Map.Entry)it.next();
                //  System.out.println(pairs.getKey() + " = " + pairs.getValue());
                  IMethod methods=(IMethod) pairs.getValue();

                  //IResource resource=(IResource) methods;

                  System.out.println("I resource value"+res);

                  System.out.println("\nlocation of the method:"+methods.getParent().getResource().toString());
                  System.out.println("\n\nmethod name ::"+methods.getElementName());

                  it.remove(); // avoids a ConcurrentModificationException
              }}
       return true; 
    }