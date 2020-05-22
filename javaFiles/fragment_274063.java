Model model = ModelUtil.create("Model");    // Returns a model
Geom g = model.geom();
g.create("geom1");               // add a component
Component c = model.geom("geom1");
c.create("circle")                          

Circle ci = c.shape("circle");
ci.name("c1", "Circle");
Feature f = ci.feature("c1");
f.label("OuterDiameter");
f.set("type", "curve");
f.set("r", "0.5");