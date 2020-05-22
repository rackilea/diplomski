public BluetoothConnector(BluetoothDevice device, boolean secure, BluetoothAdapter adapter,
                              List<UUID> uuidCandidates) 
          {
        this.device = device;
        this.secure = secure;
        this.adapter = adapter;
        this.uuidCandidates = uuidCandidates;

        if (this.uuidCandidates == null || this.uuidCandidates.isEmpty()) {
            this.uuidCandidates = new ArrayList<UUID>();
            this.uuidCandidates.add(UUID.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66"));
        }
    }