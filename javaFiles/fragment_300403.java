if (errorBuffer.get(0) != VR.EVRRenderModelError.VRRenderModelError_None) {
    return null;
}

int error;
PointerByReference pref = new PointerByReference();

while (true) {

    error = renderModels.LoadRenderModel_Async.apply(modelName, pref);

    if (error != VR.EVRRenderModelError.VRRenderModelError_Loading) {
        break;
    }

    try {
        Thread.sleep(1);
    } catch (InterruptedException ex) {
        Logger.getLogger(ModelsRender.class.getName()).log(Level.SEVERE, null, ex);
    }
}
RenderModel_t model = new RenderModel_t(pref.getValue());


public class RenderModel_t {
    public RenderModel_t(Pointer p) {
        super(p);
        read();
    }
}