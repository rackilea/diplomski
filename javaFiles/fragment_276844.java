ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)) {
                @SuppressWarnings("rawtypes")
                @Override
                protected Class resolveClass(ObjectStreamClass objectStreamClass)
                        throws IOException, ClassNotFoundException {
                    return Class.forName(objectStreamClass.getName(), true, loader);
                }
            };