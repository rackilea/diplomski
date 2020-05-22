public Transform findById(final int id) {
    class Wrapper {
        private Transform returnTransform = null;

        Transform getReturnTransorm() { return returnTransform; }

        void setReturnTransform(Transform returnTransform) {
            this.returnTransform = returnTransform;
        }
    }
    final Wrapper wrapper = new Wrapper();
    execute(new IExecutor() {
        @Override
        public boolean execute(Transform transform) {
            if (transform.getID() == id) {
                wrapper.setReturnTransform(transform);
                return true;
            }
            return false;
        }
    });

    return wrapper.getReturnTransform();
}