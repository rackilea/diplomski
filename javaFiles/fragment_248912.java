method.body = [
    val voidMethod = method.returnType === null || method.returnType.void

         ''' 
            try {
                android.util.Log.d("TAG", "«method.simpleName» start");
                «IF (!voidMethod)»«method.returnType» ret = «ENDIF»
                «prefix + method.simpleName»(«method.parameters.map[simpleName].join(", ")»);
                android.util.Log.d("TAG", "«method.simpleName» end");
                «IF (!voidMethod)»return ret;«ENDIF»
            }
            catch(RuntimeException e) {
                android.util.Log.d("TAG", "«method.simpleName» ended with exception " 
                    + e.getClass().getSimpleName() + "\n" + e.getMessage());
                throw e;                
            }
        ''']