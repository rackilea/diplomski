if (from_user == (current_user_id)) {

    return VIEW_TYPE_MESSAGE_SENT;

} else {

    return VIEW_TYPE_MESSAGE_RECEIVED;
}