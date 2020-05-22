836             // create new object when needed
837             boolean newlyCreated = false;
838             if(null == pair) {
839                 try {
840                     Object obj = _factory.makeObject();
841                     pair = new ObjectTimestampPair(obj);
842                     newlyCreated = true;
843                 } finally {
844                     if (!newlyCreated) {
845                         // object cannot be created
846                         _numActive--;
847                         notifyAll();
848                     }
849                 }
850             }