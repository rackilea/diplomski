T t = callable.call();
        if (t == null) {
            sds.onComplete();
        }
        else {
            sds.complete(t);
        }