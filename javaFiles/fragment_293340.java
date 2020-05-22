public NoteHolder(@NonNull final View itemView) {

        super(itemView);

        cardView = itemView.findViewById(R.id.cardview);
        title = itemView.findViewById(R.id.title_text);
        content = itemView.findViewById(R.id.content_text);
        priority = itemView.findViewById(R.id.priority_text);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemView.getContext().startActivity(new Intent(itemView.getContext(),Empty.class));
            }
        });


            }