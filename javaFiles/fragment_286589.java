doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                ((CrestronNioSocketHandler.NioEventReceiver) args[0]).onDataReceived(new byte[wantedNumber]);
                return null;
            }
        }).when(mockedChannel).read(any(ByteBuffer.class));