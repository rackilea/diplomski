/*
         * Create room
         */
        muc.create(roomName);

        // muc.sendConfigurationForm(new Form(Form.TYPE_SUBMIT));
        Form form = muc.getConfigurationForm();
        Form submitForm = form.createAnswerForm();

        for (Iterator fields = form.getFields(); fields.hasNext();) {
            FormField field = (FormField) fields.next();
            if (!FormField.TYPE_HIDDEN.equals(field.getType())
                    && field.getVariable() != null) {
                show("field: " + field.getVariable());
                // Sets the default value as the answer
                submitForm.setDefaultAnswer(field.getVariable());
            }
        }

        List<String> owners = new ArrayList<String>();
        owners.add(DataConfig.USERNAME + "@" + DataConfig.SERVICE);
        submitForm.setAnswer("muc#roomconfig_roomowners", owners);
        submitForm.setAnswer("muc#roomconfig_roomname", roomName);
        submitForm.setAnswer("muc#roomconfig_persistentroom", true);

        muc.sendConfigurationForm(submitForm);
        // submitForm.
        show("created room!");
        muc.addMessageListener(new PacketListener() {
            @Override
            public void processPacket(Packet packet) {
                show(packet.toXML());
                Message mess = (Message) packet;
                showMessageToUI(mess.getFrom() + ": " + mess.getBody());
            }
        });