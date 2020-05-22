companion object {
    private const val KEY_PASS_ORDER = "KEY_PASS_ORDER"

    fun newInstance(order: Orders): FragmentBayar {
        val fragment = FragmentBayar()

        val bundle = Bundle()
        bundle.putParcelable(KEY_PASS_ORDER, order)
        fragment.arguments = bundle
        return fragment
    }
}

private fun readBundle(bundle: Bundle?) {
    if (bundle != null) {
        order = bundle.getParcelable(KEY_PASS_ORDER)
    }
}