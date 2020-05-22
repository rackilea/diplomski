Component c = new Component();
(...)

MyApplication1 app1 = new MyApplication1();
c.getDefaultHost().attach("/app1", app1);

MyApplication1 app2 = new MyApplication2(app1);
c.getDefaultHost().attach("/app1", app2);

(...)