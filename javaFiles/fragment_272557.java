addPlayers.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(v.getContext(), AddPlayer.class));
    }
});