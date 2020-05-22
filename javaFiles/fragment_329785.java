class Model {

        private final Destination destination;

        private Model(Destination destination) {
            this.destination = destination;
        }

        public NavDestination getDestination() {
            return new NavDestination(destination);
        }
    }

    class NavDestination {

        private final Destination value;

        private NavDestination(Destination value) {
            this.value = value;
        }

        public Destination getValue() {
            return value;
        }

        public NavDevice getDevice() {
            return new NavDevice(value == null ? null : value.getDevice());
        }

    }

    class NavDevice {

        private final Device value;

        private NavDevice(Device value) {
            this.value = value;
        }

        public Device getValue() {
            return value;
        }

        public NavName getName() {
            return new NavName(value == null ? null : value.getName());
        }
    }

    class NavName {

        private final String value;

        private NavName(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }