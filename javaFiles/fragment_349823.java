public void setUniform(String uniformName, DirectionalLight directionalLight) {
    if (directionalLight != null) {
        setUniform(uniformName + ".base", directionalLight.getBase());
        setUniform(uniformName + ".direction", directionalLight.getDirection());
    } else {
        System.out.println("\ndirectionalLight is null, shader can not continue!");
        System.exit(1);
    }
}