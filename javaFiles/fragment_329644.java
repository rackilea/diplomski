public interface PpmlModelContainer{
    PMMLExportable getPMMLExportable();
}

 public String exportAsPMML(MLModel model) throws MLModelHandlerException {
    Externalizable extModel = model.getModel();

    if (extModel instanceof PpmlModelContainer) {
        PMMLExportable ppmlModel = ((PpmlModelContainer) extModel).getPMMLExportable();
        return ppmlModel.toPMML();
    } else {
        throw new MLModelHandlerException("PMML export not supported for model type");
    }
}