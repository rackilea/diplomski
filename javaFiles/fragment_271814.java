Method m = this.getClass().getMethod(lastStackElement.getMethodName(), String.class);
            Cache annotation = m.getAnnotation(Cache.class);
            System.out.println("Cache.minute = " + annotation.minute());
            // synchronize data from server
        }
    }