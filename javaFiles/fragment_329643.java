GeneralizedLinearModel genModel = ((MLGeneralizedLinearModel) extModel).getModel();
if (genModel instanceof PMMLExportable) {
    return ((PMMLExportable) genModel).toPMML();
} else {
    throw new MLModelHandlerException("PMML export not supported for model type");
}