public void setUniform(String uniformName, BaseLight baseLight) {
    if (baseLight != null) {
        setUniform(uniformName + ".color", baseLight.getColor());           
        setUniformf(uniformName + ".intensity", baseLight.getIntensity());
    } else {
        System.out.println("baseLight is null, shader can not conitnue!");
        System.exit(1);
    }
}