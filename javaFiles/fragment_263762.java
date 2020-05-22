IoBuffer data = streampacket.getData().asReadOnlyBuffer();

        if (data.limit() == 0) {
            return;
        }

        if (startTimeStamp == -1) {
            // That will be not bigger then long value
            startTimeStamp = streampacket.getTimestamp();
        }

        timeStamp -= startTimeStamp;

        ITag tag = new Tag();
        tag.setDataType(streampacket.getDataType());

        // log.debug("data.limit() :: "+data.limit());
        tag.setBodySize(data.limit());
        tag.setTimestamp(timeStamp);
        tag.setBody(data);

        writer.writeTag(tag);