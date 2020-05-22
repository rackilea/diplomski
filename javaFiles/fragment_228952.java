class OnceOnlyThingDoer {
        private boolean done = false;

        public OnceOnlyThingDoer(...) {
            // set member variables e.g. the target POJO
        }

        public void record(int[] line) {
            if(!done) {
                doTheThing(line); // e.g. call your method on the target POJO
                done = true;
            }

        }
   }