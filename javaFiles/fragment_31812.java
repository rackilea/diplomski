fun newInstance(order: Orders): FragmentBayar {
    val fragment = FragmentBayar()

    val bundle = Bundle()
    /* here --> */bundle.putParcelable(fragment.getString(R.string.key_pass_order), order)
    fragment.arguments = bundle
    return fragment
}