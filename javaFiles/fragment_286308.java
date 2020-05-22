class FragmentRegisterComplaint : BaseFragment() {
    companion object {
        @JvmStatic
        fun getInstance(bundle: Bundle, title: String, icon: Int): FragmentRegisterComplaint {
            val fragment = FragmentRegisterComplaint()
            fragment.arguments = bundle
            fragment.setFragmentTitle(title)
            fragment.setFragmentIconId(icon)
            return fragment
        }
    }
}