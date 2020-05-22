where the ListPointer structure can then be initialized as follows:

    list.fds[0].fd = file_descriptorA;
    list.fds[0].events = requested_events;
    list.msgs[0].msgid = message_id;
    list.msgs[0].events = requested_events;