public void handle(short id, byte[] b) {
        data.add(new HandlePacket(id, b));
        executor.execute(new Processor(data));
    }

    class Processor implements Runnable {

        private BlockingQueue<HandlePacket> dataSource;

        public Processor(BlockingQueue<HandlePacket> dataSource) {
            this.dataSource = dataSource;
        }

        @Override
        public void run() {
            HandlePacket hp = null;
            while ((hp = dataSource.poll()) != null) {
                if(hp != null) {
                    PacketType type = PacketType.getById(hp.id);
                    if(type == null) {
                        continue;
                    }
                    Event event = type.getPacket(hp.b).createEvent();
                    for(PacketListenerInfo listener : listeners) {
                        for(Method method : listener.methods) {
                            if(method.getParameterTypes()[0].isInstance(event)) {
                                try {
                                    method.invoke(listener.listener, event);
                                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
            }
        }
    }