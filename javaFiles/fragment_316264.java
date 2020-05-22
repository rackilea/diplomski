ReferenceQueue<Foo> q = new ReferenceQueue<Foo>();
        PhantomReference<Foo> pr = new PhantomReference<Foo>(new Foo("myphantom"), q);
        System.gc();
        System.runFinalization();
        System.gc();
        System.runFinalization();
//      Reference<? extends Foo> remove = q.remove(5000L); 
        System.out.println(q.poll());