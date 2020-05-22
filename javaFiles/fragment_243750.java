public boolean onClose() {
    if (someCondition) {
        // do something
        return false;
    } else
        return super.onClose();
}