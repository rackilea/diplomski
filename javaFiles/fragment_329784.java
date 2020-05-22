class Destination {

        private final Device device;

        public Destination(Device device) {
            this.device = device;
        }

        public Device getDevice() {
            return device;
        }
    }

    class Device {

        private final String name;

        private Device(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }