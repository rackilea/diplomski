/**
     *
     *
     *
     */
    public class Device {

        /** */
        private final byte[] code; // code don't need to be static. Static is for field who need to be shared over class/packages like constant or global field. If code

        /**
         *
         * @param code
         */
        public Device (final byte[] newCode) {

         this.code = Arrays.copyOf(newCode, newCode.length) ; ASSIGN A COPY
        }

        /**
         *
         * @return
         */
        public byte[] getCode() {
            return Arrays.copyOf(code, code.length); // RETURN A COPY
        }

    }