message = getMessageBuilderFactory().withPayload(payload)
                    .setHeader(IpHeaders.HOSTNAME, hostName)
                    .setHeader(IpHeaders.IP_ADDRESS, hostAddress)
                    .setHeader(IpHeaders.PORT, port)
                    .setHeader(IpHeaders.PACKET_ADDRESS, packet.getSocketAddress())
                    .build();