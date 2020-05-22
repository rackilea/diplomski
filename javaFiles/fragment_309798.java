// connector already created and set up

ProjectConnection connection = connector.connect();
BuildLauncher build = connection.newBuild();
build.forTasks("clean");

OutputStream outputStream = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                System.out.print((char) b); // or output it to anywhere else you'd like
            }
        };

build.setStandardOutput(outputStream);
build.setStandardError(outputStream);

build.run();

connection.close();