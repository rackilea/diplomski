public void testCatchException() {
            try {
                checkClassesExisting();
            } catch (ClassNotFoundException ex) {
                // TODO handle exception
            } catch (NoClassDefFoundError ex) {
                // TODO handle exception
            } catch (Exception ex) {
                // other error
            }
        }


        public void checkClassesExisting() throws Exception {
            // instantiate here the class in doubt
            Dummy = new Dummy("xx");
        }