// in ArchiveContainer:
<II extends I, DD extends ItemDescriptor<II>> II getItem(DD descriptor);

// in ChannelArchive:
public <II extends ByteChannel, DD extends ItemDescriptor<II>>
    II getItem(DD descriptor)
    { ... }