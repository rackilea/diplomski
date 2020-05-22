public SchemaAttributes(String name, String type, Boolean nullable, int preciesion, int scale) {
    this.name = name;
    this.type = type;
    this.nullable = nullable;
    this.precision = precision;
    this.scale = scale;
}

public SchemaAttributes(String name, String type, Boolean nullable) {
    this(name, type, nullable, 0, 0);
}

public SchemaAttributes() {
    this("unknown", "unknown", true);
}