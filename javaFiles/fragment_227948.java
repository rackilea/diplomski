@PrePersist
void setBidirectionalMappingsOnPersist() {
    if (elements != null) {
        elements.forEach(element -> element.setResource(this));
    }
}