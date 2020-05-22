/**
 * Shared empty array instance used for empty instances.
 */
private static final Object[] EMPTY_ELEMENTDATA = {};

public ArrayList() {
    super();
    this.elementData = EMPTY_ELEMENTDATA;
}