public void onClick(View view) {
    Intent intent = Intent(getActivity(),Form1.class);
    intent.putExtra("username", username);
    intent.putExtra("password", password);
    getActivity().startActivity(intent);
}