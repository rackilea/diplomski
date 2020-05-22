public ParticipantsSelectedListAdapter(Context context, int a, ArrayList<Participants> participants) {
        super(context, 0, participants);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Participants participants = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_participants_selected, parent, false);
        }
        // Lookup view for data population
        TextView tvFirstName = (TextView) convertView.findViewById(R.id.tvFirstName);
        TextView tvPosition = (TextView) convertView.findViewById(R.id.tvPosition);
        CheckBox ckb = (CheckBox) convertView.findViewById(R.id.ckb);

        // Populate the data into the template view using the data object
        tvFirstName.setText(participants.getFirstName());
        tvPosition.setText(participants.getPosition());

        if(participants.isSelected) {
            ckb.setChecked(true);
        }else {
            ckb.setChecked(false);
        }

        ckb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                participants.setSelected(!participants.isSelected());
                notifyDataSetChanged();
            }
        });

        // Return the completed view to render on screen

        return convertView;
    }