View rootView = inflater.inflate(R.layout.fragment_main, container,
            false);

Button saveBtn = (Button)rootView.findViewById(R.id.save);
saveBtn.setOnClickListener(...);

return rootView;