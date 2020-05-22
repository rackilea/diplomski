if (context instanceof OnFragmentInteractionListener) {
    mListener = (OnFragmentInteractionListener) context;
} else {
    throw new RuntimeException(context.toString()
        + " must implement OnFragmentInteractionListener");
}