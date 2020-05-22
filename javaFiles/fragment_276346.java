private static void visit(CallGraph cg, SootMethod method) {
          String identifier = method.getSignature();
          visited.put(method.getSignature(), true);
          dot.drawNode(identifier);
          // iterate over unvisited parents
          Iterator<MethodOrMethodContext> ptargets = new Sources(cg.edgesInto(method));
          if (ptargets != null) {
            while (ptargets.hasNext()) {
                SootMethod parent = (SootMethod) ptargets.next();
                if (!visited.containsKey(parent.getSignature()) && !parent.isJavaLibraryMethod()) visit(cg, parent);
            }
          }
          // iterate over unvisited children
          Iterator<MethodOrMethodContext> ctargets = new Targets(cg.edgesOutOf(method));
          if (ctargets != null) {
            while (ctargets.hasNext()) {
               SootMethod child = (SootMethod) ctargets.next();
               dot.drawEdge(identifier, child.getSignature());
               if (!child.isJavaLibraryMethod())System.out.println(method + " may call " + child);
               if (!visited.containsKey(child.getSignature()) && !child.isJavaLibraryMethod()) visit(cg, child);
            }
          }
    }