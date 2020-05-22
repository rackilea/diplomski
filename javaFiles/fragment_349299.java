@Override
        protected void addSpecificHandlers(ChannelPipeline pipeline) {
            pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(255, 2, 1, 2, 0));
            pipeline.addLast("stringEncoder", new StringEncoder());
            pipeline.addLast("stringDecoder", new StringDecoder());
            pipeline.addLast("objectDecoder", new EquipProtocolDecoder(EquipProtocol.this));
        }