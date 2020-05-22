bootstrap.handler(new ChannelInitializer<Channel>() {
            @Override
            public void initChannel(Channel channel) throws Exception {
                getPacketProtocol().newClientSession(client, TcpClientSession.this);

                channel.config().setOption(ChannelOption.IP_TOS, 0x18);
                channel.config().setOption(ChannelOption.TCP_NODELAY, false);

                ChannelPipeline pipeline = channel.pipeline();

                refreshReadTimeoutHandler(channel);
                refreshWriteTimeoutHandler(channel);

                pipeline.addLast("encryption", new TcpPacketEncryptor(TcpClientSession.this));
                pipeline.addLast("traffic", new ChannelTrafficShapingHandler(0, MAXCHANNELTHROUGHPUT, 1000)); // ADDED
                pipeline.addLast("sizer", new TcpPacketSizer(TcpClientSession.this));
                pipeline.addLast("codec", new TcpPacketCodec(TcpClientSession.this));
                pipeline.addLast("manager", TcpClientSession.this);
            }
        }).group(this.group).option(ChannelOption.CONNECT_TIMEOUT_MILLIS, getConnectTimeout() * 1000);