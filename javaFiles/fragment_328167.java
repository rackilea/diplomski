private final static int m_off_addressed_center           = 0;
private final static int m_off_record_version             = m_off_addressed_center + 1;
private final static int m_off_num_records                = m_off_record_version + 1;
private final static int m_off_buffer_used                = m_off_num_records + 4;
private final static int m_off_address                    = m_off_buffer_used + 4;
private final static int m_off_address_from               = m_off_address + 8;
private final static int m_off_records_partition          = m_off_address_from + 8;
private final static int m_off_already_replicated         = m_off_records_partition + 1;

private final static int m_head_offset = m_off_already_replicated + 1;