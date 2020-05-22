Constructor constructor = new Constructor() {
    @Override
    public Object constructScalar(ScalarNode node) {
        if (isToken(node.getValue()) {
            return interpolateToken(node.getValue());
        }

        return super.constructScalar(node);
    }
}

Yaml yaml = new Yaml(constructor);
yaml.load(yamlReader);