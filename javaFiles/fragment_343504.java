@JsonCreator
public CrudOperation(@JsonProperty("type") Type type, @JsonProperty("op") JsonNode op) {
    this.type = type;
    this.op = null == op || op.isNull() ? null : op;

    boolean isUpdate = Type.UPDATE.equals(this.getType());
    boolean isNotNull = null == this.getOp();
    boolean isValid = isUpdate ^ isNotNull;

    if (!isValid) {
        System.out.println(" isUpdate: " + String.valueOf(isUpdate));
        System.out.println("isNotNull: " + String.valueOf(isNotNull));
        System.out.println("  isValid: " + String.valueOf(isValid));
        System.out.println("    class:" + (null == op ? "Real Null" : op.getClass().toString()));

        throw new IllegalArgumentException("Operation Failed Validation: " + this.toString());
    }
}