Variant.VARIANT.ByValue var1 = new Variant.VARIANT.ByValue();
Variant.VARIANT.ByValue var2 = new Variant.VARIANT.ByValue();

var2.setValue(Variant.VT_INT, ControlType.Window);
var1.setValue(Variant.VT_BSTR, sysAllocated);

this.handler.CreatePropertyCondition(PropertyID.Name.getValue(), var1, pbr0);
this.handler.CreatePropertyCondition(PropertyID.ControlType.getValue(), var2, pbr1);
this.handler.CreateAndCondition(pbr0.getValue(), pbr1.getValue(), pbr);